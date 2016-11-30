/*******************************************************************************
 * Copyright 2016 Sistcoop, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package org.openfact.ubl;

import java.util.List;

import org.openfact.models.CreditNoteModel;
import org.openfact.models.DebitNoteModel;
import org.openfact.models.InvoiceModel;
import org.openfact.models.OrganizationModel;
import org.openfact.models.ScrollModel;
import org.openfact.models.enums.SendResultType;
import org.openfact.models.search.SearchCriteriaModel;
import org.openfact.models.search.SearchResultsModel;
import org.openfact.provider.Provider;

public interface SendEventProvider extends Provider {

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type, InvoiceModel sendEvent);

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type,
            CreditNoteModel creditNote);

    SendEventModel addSendEvent(OrganizationModel organization, SendResultType type,
            DebitNoteModel debitNote);

    SendEventModel getSendEventById(OrganizationModel organization, String id);

    boolean removeSendEvent(OrganizationModel organization, String id);

    boolean removeSendEvent(OrganizationModel organization, SendEventModel sendEvent);

    List<SendEventModel> getSendEvents(OrganizationModel organization);

    List<SendEventModel> getSendEvents(OrganizationModel organization, Integer firstResult,
            Integer maxResults);

    SearchResultsModel<SendEventModel> searchForSendEvent(OrganizationModel organization,
            SearchCriteriaModel criteria);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc,
            int scrollSize);

    ScrollModel<SendEventModel> getSendEventsScroll(OrganizationModel organization, boolean asc,
            int scrollSize, int fetchSize);

}