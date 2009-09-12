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
 *
 * @date 4 Aug 2009
 *
 */
public class ListComponents {

	private long documentId;
	
	private long componentsId;
	
	private double price;
	
	private double discountApplied;
	
	public ListComponents() {
		super();
	}

	/**
	 * @return the documentId
	 */
	public long getDocumentId() {
		return documentId;
	}

	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(long documentId) {
		this.documentId = documentId;
	}

	/**
	 * @return the componentsId
	 */
	public long getComponentsId() {
		return componentsId;
	}

	/**
	 * @param componentsId the componentsId to set
	 */
	public void setComponentsId(long componentsId) {
		this.componentsId = componentsId;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof ListComponents)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		ListComponents listComponents = (ListComponents) obj;
		return new EqualsBuilder()
			.append(documentId, listComponents.getDocumentId())
			.append(componentsId, listComponents.getComponentsId())
			.append(price, listComponents.getPrice())
			.append(discountApplied, listComponents.getDiscountApplied())
			.isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(documentId)
		.append(componentsId)
		.append(price)
		.append(discountApplied)
		.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(documentId)
			.append(componentsId)
			.append(price)
			.append(discountApplied)
			.toString();
	}

}