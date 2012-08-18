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

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Carlos Fernandez
 * @date 20 Sep 2009
 * <p/>
 * Representation of a component that belongs to a document.
 */
public class DocumentComponent {

    private long id;

    private String code;

    private String description;

    private double price;

    private double discountApplied;

    private double quantity;

    private Document document;

    public DocumentComponent() {
        super();
    }

    /**
     * @return the document component id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return the discountApplied
     */
    public double getDiscountApplied() {
        return discountApplied;
    }

    /**
     * @param discountApplied the discountApplied to set
     */
    public void setDiscountApplied(double discountApplied) {
        this.discountApplied = discountApplied;
    }

    /**
     * @return the quantity of component
     */
    public double getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the document this documentComponent belongs to
     */
    public Document getDocument() {
        return document;
    }

    /**
     * @param document the document this documentComponent belongs to
     */
    public void setDocument(Document document) {
        this.document = document;
    }

    /* (non-Javadoc)
      * @see java.lang.Object#toString()
      */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append(code)
                .append(description)
                .append(price)
                .append(discountApplied)
                .toString();
    }

    /* (non-Javadoc)
      * @see java.lang.Object#equals(java.lang.Object)
      */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof DocumentComponent)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        DocumentComponent documentComponent = (DocumentComponent) obj;
        return new EqualsBuilder()
                .append(code, documentComponent.getCode())
                .append(description, documentComponent.getDescription())
                .append(price, documentComponent.getPrice())
                .append(discountApplied, documentComponent.getDiscountApplied())
                .isEquals();
    }

    /* (non-Javadoc)
      * @see java.lang.Object#hashCode()
      */
    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(code)
                .append(description)
                .append(price)
                .append(discountApplied)
                .toHashCode();
    }

}