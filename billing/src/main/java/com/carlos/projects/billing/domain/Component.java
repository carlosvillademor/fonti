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
 * @date 25 Jul 2009
 *
 */
public class Component {

	private long id;
	
	private String name;
	
	private String description;
	
	private double minimunDiscount;
	
	private double maximunDiscount;

	public Component() {
		super();
	}
	
	/**
	 * @return the id
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the minimunDiscount
	 */
	public double getMinimunDiscount() {
		return minimunDiscount;
	}

	/**
	 * @param minimunDiscount the minimunDiscount to set
	 */
	public void setMinimunDiscount(double minimunDiscount) {
		this.minimunDiscount = minimunDiscount;
	}

	/**
	 * @return the maximunDiscount
	 */
	public double getMaximunDiscount() {
		return maximunDiscount;
	}

	/**
	 * @param maximunDiscount the maximunDiscount to set
	 */
	public void setMaximunDiscount(double maximunDiscount) {
		this.maximunDiscount = maximunDiscount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
			.append(id)
			.append(name)
			.append(description)
			.append(minimunDiscount)
			.append(maximunDiscount)
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
		.append(id, component.getId())
		.append(name, component.getName())
		.append(description, component.getDescription())
		.append(minimunDiscount, component.getMinimunDiscount())
		.append(maximunDiscount, component.getMaximunDiscount())
		.isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(id)
		.append(name)
		.append(description)
		.append(minimunDiscount)
		.append(maximunDiscount)
		.hashCode();
	}
	
	
}