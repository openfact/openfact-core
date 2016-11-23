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
package org.openfact.ubl;

import java.util.Map;

import org.openfact.models.OpenfactSession;
import org.openfact.models.OrganizationModel;
import org.w3c.dom.Document;

import com.helger.ubl21.UBL21Reader;
import com.helger.ubl21.UBL21Writer;

import oasis.names.specification.ubl.schema.xsd.debitnote_21.DebitNoteType;

public class DefaultDebitNoteReaderWriterProvider implements DebitNoteReaderWriterProvider {

    protected OpenfactSession session;

    public DefaultDebitNoteReaderWriterProvider(OpenfactSession session) {
        this.session = session;
    }

    @Override
    public void close() {
    }

    @Override
    public DebitNoteType read(byte[] bytes) {
        return UBL21Reader.debitNote().read(bytes);
    }

    @Override
    public Document writeAsDocument(OrganizationModel organization, DebitNoteType invoice,
            Map<String, String> attributes) {
        return UBL21Writer.debitNote().getAsDocument(invoice);
    }

}
