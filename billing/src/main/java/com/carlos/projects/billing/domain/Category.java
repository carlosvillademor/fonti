/**
 * @author Carlos Fernandez
 *
 * @date 3 Aug 2009
 *
 */
package com.carlos.projects.billing.domain;

import java.util.Set;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class Category {

	private long id;
	
	private String name;
	
	private String description;
	
	private Set<Component> components;
	
	public Category() {
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
	 * @return the components
	 */
	public Set<Component> getComponents() {
		return components;
	}

	/**
	 * @param components the components to set
	 */
	public void setComponents(Set<Component> components) {
		this.components = components;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Category)) {
			return false;
		}
		if(obj == this) {
			return true;
		}
		Category category = (Category) obj;
		return new EqualsBuilder()
			.append(id, category.getId())
			.append(name, category.getName())
			.append(description, category.getDescription())
			.append(components, category.getComponents())
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
		.append(components)
		.hashCode();
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
			.append(components)
			.toString();
	}

}