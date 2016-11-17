/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.services.resources.admin;

import org.jboss.resteasy.annotations.cache.NoCache;
import org.jboss.resteasy.spi.ResteasyProviderFactory;
import org.openfact.common.ClientConnection;
import org.openfact.email.EmailException;
import org.openfact.events.admin.OperationType;
import org.openfact.models.ModelDuplicateException;
import org.openfact.models.ModelException;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.enums.RequiredActionDocument;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.models.ubl.DebitNoteModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.models.utils.RepresentationToModel;
import org.openfact.representations.idm.search.SearchCriteriaRepresentation;
import org.openfact.representations.idm.search.SearchResultsRepresentation;
import org.openfact.representations.idm.ubl.DebitNoteRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.DebitNoteManager;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DebitNotesAdminResource {

    public static final String SCOPE_DEBIT_NOTE_VIEW = "urn:openfact.com:scopes:organization:debitnote:view";
    public static final String SCOPE_DEBIT_NOTE_MANAGE = "urn:openfact.com:scopes:organization:debitnote:manage";

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    @Context
    protected UriInfo uriInfo;
    @Context
    protected OpenfactSession session;
    @Context
    protected ClientConnection clientConnection;
    @Context
    protected HttpHeaders headers;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    public DebitNotesAdminResource(OrganizationModel organization, OrganizationAuth auth,
                                   AdminEventBuilder adminEvent) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;

        auth.init(OrganizationAuth.Resource.DEBIT_NOTE);
    }

    /**
     * @param debitNoteId
     *            The debitNoteId of the debitNote
     */
    @Path("{debitNoteId}")
    public DebitNoteAdminResource getDebitNoteAdmin(@PathParam("debitNoteId") final String debitNoteId) {
        DebitNoteModel debitNote = session.debitNotes().getDebitNoteById(organization, debitNoteId);
        if (debitNote == null) {
            throw new NotFoundException("Debit Note not found");
        }

        DebitNoteAdminResource debitNoteResource = new DebitNoteAdminResource(organization, auth, adminEvent,
                debitNote);
        ResteasyProviderFactory.getInstance().injectProperties(debitNoteResource);
        return debitNoteResource;
    }

    @GET
    @NoCache
    @Produces(MediaType.APPLICATION_JSON)
    public List<DebitNoteRepresentation> getDebitNotes(@QueryParam("filterText") String filterText,
                                                       @QueryParam("first") Integer firstResult, @QueryParam("max") Integer maxResults) {
        auth.requireView();

        firstResult = firstResult != null ? firstResult : -1;
        maxResults = maxResults != null ? maxResults : -1;

        List<DebitNoteModel> debitNotes;
        if (filterText != null) {
            debitNotes = session.debitNotes().searchForDebitNote(organization, filterText.trim(), firstResult,
                    maxResults);
        } else {
            debitNotes = session.debitNotes().getDebitNotes(organization, firstResult, maxResults);
        }
        return debitNotes.stream().map(f -> ModelToRepresentation.toRepresentation(f, false))
                .collect(Collectors.toList());
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response createDebitNote(@Valid final DebitNoteRepresentation rep) {
        auth.requireManage();

        DebitNoteManager debitNoteManager = new DebitNoteManager(session);

        // Double-check duplicated ID
        if (rep.getIdUbl() != null
                && debitNoteManager.getDebitNoteByID(organization, rep.getIdUbl()) != null) {
            return ErrorResponse.exists("Debit Note exists with same ID");
        }

        try {
            DebitNoteModel debitNote = debitNoteManager.addDebitNote(organization, rep);

            adminEvent.operation(OperationType.CREATE).resourcePath(uriInfo, debitNote.getId())
                    .representation(rep).success();

            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().commit();
            }

            // Send Email
            if (rep.getRequiredActions().contains(RequiredActionDocument.SEND_EMAIL_CUSTOMER.toString())) {
                debitNoteManager.sendEmailToCustomerEmail(organization, debitNote);
            }

            URI location = uriInfo.getAbsolutePathBuilder().path(debitNote.getId()).build();
            return Response.created(location).build();
        } catch (ModelDuplicateException e) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Debit Note exists with same id or ID");
        } catch (ModelException me) {
            if (session.getTransactionManager().isActive()) {
                session.getTransactionManager().setRollbackOnly();
            }
            return ErrorResponse.exists("Could not create debit note");
        } catch (EmailException e) {
            ServicesLogger.LOGGER.failedToSendActionsEmail(e);
            return ErrorResponse.error("Invoice Created but, Failed to send execute actions email", Response.Status.INTERNAL_SERVER_ERROR);
        }
    }

    @POST
    @Path("search")
    @Produces(MediaType.APPLICATION_JSON)
    public SearchResultsRepresentation<DebitNoteRepresentation> search(
            final SearchCriteriaRepresentation criteria) {
        auth.requireView();

        SearchCriteriaModel criteriaModel = RepresentationToModel.toModel(criteria);

        String filterText = criteria.getFilterText();
        SearchResultsModel<DebitNoteModel> results = null;
        if (filterText == null) {
            results = session.debitNotes().searchForDebitNote(organization, criteriaModel);
        } else {
            results = session.debitNotes().searchForDebitNote(organization, criteriaModel, filterText);
        }
        SearchResultsRepresentation<DebitNoteRepresentation> rep = new SearchResultsRepresentation<>();
        List<DebitNoteRepresentation> items = new ArrayList<>();
        results.getModels().forEach(f -> items.add(ModelToRepresentation.toRepresentation(f, false)));
        rep.setItems(items);
        rep.setTotalSize(results.getTotalSize());
        return rep;
    }

}
