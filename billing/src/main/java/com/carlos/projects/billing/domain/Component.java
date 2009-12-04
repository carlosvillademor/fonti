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
 * Normative definition of a Component
 *
 * @author Carlos Fernandez
 * @date 25 Jul 2009
 */
public class Component {

    private String code;

    private String description;

    private double price;

    private double discount1;

    private double discount2;

    public Component() {
        super();
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
     * @return the discount1
     */
    public double getDiscount1() {
        return discount1;
    }

    /**
     * @param discount1 the discount1 to set
     */
    public void setDiscount1(double discount1) {
        this.discount1 = discount1;
    }

    /**
     * @return the discount2
     */
    public double getDiscount2() {
        return discount2;
    }

    /**
     * @param discount2 the discount2 to set
     */
    public void setDiscount2(double discount2) {
        this.discount2 = discount2;
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
                .append(discount1)
                .append(discount2)
                .toString();
    }

    /* (non-Javadoc)
      * @see java.lang.Object#equals(java.lang.Object)
      */
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Component)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        Component component = (Component) obj;
        return new EqualsBuilder()
                .append(code, component.getCode())
                .append(description, component.getDescription())
                .append(price, component.getPrice())
                .append(discount1, component.getDiscount1())
                .append(discount2, component.getDiscount2())
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
                .append(discount1)
                .append(discount2)
                .hashCode();
    }

}