/**
 * Fonti is a web application for billing and budgeting
 * Copyright (C) 2009  Carlos Fernandez
 *
 * This file is part of Fonti.
 *
 * Fonti is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Fonti is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.carlos.projects.billing.domain;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: Carlos Fernandez
 * @date: 29-Jul-2010
 * <p/>
 * Representation for a document
 */
public class Document {

    private long id;

    private List<DocumentComponent> documentComponents = new ArrayList<DocumentComponent>();

    public Document() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<DocumentComponent> getDocumentComponents() {
        return documentComponents;
    }

    public void setDocumentComponents(DocumentComponent... documentComponents) {
        this.documentComponents = Arrays.asList(documentComponents);
    }

    public void setDocumentComponents(List<DocumentComponent> documentComponents) {
        this.documentComponents = documentComponents;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Document)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Document document = (Document) obj;
        return id == document.getId() && documentComponents.size() == document.getDocumentComponents().size() && documentComponents.containsAll(document.getDocumentComponents());
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(id)
                .append(documentComponents)
                .toHashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(id)
                .append(documentComponents)
                .toString();
    }

}