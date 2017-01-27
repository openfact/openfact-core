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

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ATTATCHED_DOCUMENT")
@NamedQueries(value = {
        @NamedQuery(name = "deleteAttatchedDocumentByOrganization", query = "delete from AttatchedDocumentEntity doc where doc.document IN (select i from DocumentEntity i where i.organizationId=:organizationId)")
})
public class AttatchedDocumentEntity {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Access(AccessType.PROPERTY)
    private String id;

    @Column(name = "RELATED_DOCUMENT_TYPE")
    private String relatedDocumentType;

    @Column(name = "RELATED_DOCUMENT_ID")
    private String relatedDocumentId;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(foreignKey = @ForeignKey, name = "DOCUMENT_ID")
    private DocumentEntity document;

    @OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true, mappedBy = "attatchedDocument")
    private Collection<AttatchedDocumentAttributeEntity> attributes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof AttatchedDocumentEntity)) return false;

        AttatchedDocumentEntity that = (AttatchedDocumentEntity) o;

        if (!getId().equals(that.getId())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRelatedDocumentType() {
        return relatedDocumentType;
    }

    public void setRelatedDocumentType(String relatedDocumentType) {
        this.relatedDocumentType = relatedDocumentType;
    }

    public String getRelatedDocumentId() {
        return relatedDocumentId;
    }

    public void setRelatedDocumentId(String relatedDocumentId) {
        this.relatedDocumentId = relatedDocumentId;
    }

    public DocumentEntity getDocument() {
        return document;
    }

    public void setDocument(DocumentEntity document) {
        this.document = document;
    }

    public Collection<AttatchedDocumentAttributeEntity> getAttributes() {
        return attributes;
    }

    public void setAttributes(Collection<AttatchedDocumentAttributeEntity> attributes) {
        this.attributes = attributes;
    }
}