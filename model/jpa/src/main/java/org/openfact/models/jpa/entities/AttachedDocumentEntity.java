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
//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.14 at 11:44:49 AM PET 
//

package org.openfact.models.jpa.entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "ATTACHED_DOCUMENT")
@IdClass(AttachedDocumentEntity.Key.class)
@NamedQueries(value = {
        @NamedQuery(name = "getAttachedDocumentsDestinyByOrigin", query = "select a.documentDestiny from AttachedDocumentEntity a where a.documentOrigin.id=:documentOriginId"),
        @NamedQuery(name = "getAttachedDocumentsOriginByDestiny", query = "select a.documentOrigin from AttachedDocumentEntity a where a.documentDestiny.id=:documentDestinyId"),
        @NamedQuery(name = "deleteAttachedDocumentsByOrganization", query = "delete from AttachedDocumentEntity at where at.documentOrigin IN (select doc from DocumentEntity doc where doc.organization.id=:organizationId)")
})
public class AttachedDocumentEntity {

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ORIGIN_ID")
    protected DocumentEntity documentOrigin;

    @Id
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_DESTINY_ID")
    protected DocumentEntity documentDestiny;

    public DocumentEntity getDocumentOrigin() {
        return documentOrigin;
    }

    public void setDocumentOrigin(DocumentEntity ublDocument) {
        this.documentOrigin = ublDocument;
    }

    public DocumentEntity getDocumentDestiny() {
        return documentDestiny;
    }

    public void setDocumentDestiny(DocumentEntity attachedUblDocument) {
        this.documentDestiny = attachedUblDocument;
    }

    public static class Key implements Serializable {

        protected DocumentEntity documentOrigin;

        protected DocumentEntity documentDestiny;

        public Key() {
        }

        public Key(DocumentEntity ublDocument, DocumentEntity attachedUblDocument) {
            this.documentOrigin = ublDocument;
            this.documentDestiny = attachedUblDocument;
        }

        public DocumentEntity getDocumentOrigin() {
            return documentOrigin;
        }

        public DocumentEntity getDocumentDestiny() {
            return documentDestiny;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Key key = (Key) o;

            if (documentOrigin != null ? !documentOrigin.getId().equals(key.documentOrigin != null ? key.documentOrigin.getId() : null) : key.documentOrigin != null)
                return false;
            if (documentDestiny != null ? !documentDestiny.getId().equals(key.documentDestiny != null ? key.documentDestiny.getId() : null) : key.documentDestiny != null)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = documentOrigin != null ? documentOrigin.getId().hashCode() : 0;
            result = 31 * result + (documentDestiny != null ? documentDestiny.hashCode() : 0);
            return result;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof OrganizationAttributeEntity)) return false;

        AttachedDocumentEntity key = (AttachedDocumentEntity) o;

        if (documentOrigin != null ? !documentOrigin.getId().equals(key.documentOrigin != null ? key.documentOrigin.getId() : null) : key.documentOrigin != null)
            return false;
        if (documentDestiny != null ? !documentDestiny.getId().equals(key.documentDestiny != null ? key.documentDestiny.getId() : null) : key.documentDestiny != null)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = documentOrigin != null ? documentOrigin.getId().hashCode() : 0;
        result = 31 * result + (documentDestiny != null ? documentDestiny.hashCode() : 0);
        return result;
    }

}
