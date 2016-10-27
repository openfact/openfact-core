package org.openfact.services.resources.admin;

import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.openfact.common.ClientConnection;
import org.openfact.events.admin.OperationType;
import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ubl.InvoiceModel;
import org.openfact.models.utils.ModelToRepresentation;
import org.openfact.representations.idm.ubl.InvoiceRepresentation;
import org.openfact.representations.idm.ubl.common.InvoiceLineRepresentation;
import org.openfact.services.ErrorResponse;
import org.openfact.services.ServicesLogger;
import org.openfact.services.managers.InvoiceManager;

public class InvoiceAdminResourceImpl implements InvoiceAdminResource {

    private static final ServicesLogger logger = ServicesLogger.LOGGER;

    protected OrganizationModel organization;
    protected InvoiceModel invoice;
    private OrganizationAuth auth;
    private AdminEventBuilder adminEvent;

    @Context
    protected UriInfo uriInfo;

    @Context
    protected OpenfactSession session;

    @Context
    protected ClientConnection clientConnection;

    @Context
    protected HttpHeaders headers;

    public InvoiceAdminResourceImpl(OrganizationModel organization, OrganizationAuth auth,
            AdminEventBuilder adminEvent, InvoiceModel invoice) {
        this.auth = auth;
        this.organization = organization;
        this.adminEvent = adminEvent;
        this.invoice = invoice;

        auth.init(OrganizationAuth.Resource.INVOICE);
    }

    @Override
    public InvoiceRepresentation getInvoice() {
        auth.requireView();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        InvoiceRepresentation rep = ModelToRepresentation.toRepresentation(invoice);
        return rep;
    }

    @Override
    public List<InvoiceLineRepresentation> getLines() {
        auth.requireView();

        return invoice.getInvoiceLine().stream().map(f -> ModelToRepresentation.toRepresentation(f))
                .collect(Collectors.toList());
    }

    @Override
    public Response deleteInvoice() {
        auth.requireManage();

        if (invoice == null) {
            throw new NotFoundException("Invoice not found");
        }

        boolean removed = new InvoiceManager(session).removeInvoice(organization, invoice);
        if (removed) {
            adminEvent.operation(OperationType.DELETE).resourcePath(uriInfo).success();
            return Response.noContent().build();
        } else {
            return ErrorResponse.error("Invoice couldn't be deleted", Response.Status.BAD_REQUEST);
        }
    }

}
