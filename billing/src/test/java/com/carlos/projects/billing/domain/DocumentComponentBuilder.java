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

/**
 * @author: Carlos Fernandez
 * @date: 13 Feb 2011
 */
public class DocumentComponentBuilder {

    private DocumentComponent documentComponent;

    public DocumentComponentBuilder() {
        documentComponent = new DocumentComponent();
    }

    public DocumentComponentBuilder withId(long id) {
        documentComponent.setId(id);
        return this;
    }

    public DocumentComponentBuilder withCode(String code) {
        documentComponent.setCode(code);
        return this;
    }

    public DocumentComponentBuilder withDescription(String description) {
        documentComponent.setDescription(description);
        return this;
    }

    public DocumentComponentBuilder withDiscountApplied(double discountApplied) {
        documentComponent.setDiscountApplied(discountApplied);
        return this;
    }

    public DocumentComponentBuilder withDocument(Document document) {
        documentComponent.setDocument(document);
        return this;
    }

    public DocumentComponentBuilder withPrice(double price) {
        documentComponent.setPrice(price);
        return this;
    }

    public DocumentComponentBuilder withQuantity(double quantity) {
        documentComponent.setQuantity(quantity);
        return this;
    }

    public DocumentComponent build() {
        return documentComponent;
    }

}