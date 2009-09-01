package com.carlos.projects.billing.domain;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * @author Carlos Fernandez
 *
 * @date 11 Jul 2009
 * 
 * Class that defines a company to use the billing application
 *
 */
public class Company {
	
	private Long id;
	
	private String name;
	
	private String nationalInsuranceNumber;
	
	private String phoneNumber;
	
	private String emailAddress;
	
	private Address address;
	
	private String bankAccount;
	
	public Company () {
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the nationalInsuranceNumber
	 */
	public String getNationalInsuranceNumber() {
		return nationalInsuranceNumber;
	}

	/**
	 * @param nationalInsuranceNumber the nationalInsuranceNumber to set
	 */
	public void setNationalInsuranceNumber(String nationalInsuranceNumber) {
		this.nationalInsuranceNumber = nationalInsuranceNumber;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}

	/**
	 * @return the bankAccount
	 */
	public String getBankAccount() {
		return bankAccount;
	}

	/**
	 * @param bankAccount the bankAccount to set
	 */
	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Company)) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		Company otherCompany = (Company) obj;
		return new EqualsBuilder()
		.append(id, otherCompany.getId())
		.append(name, otherCompany.getName())
		.append(nationalInsuranceNumber, 
				otherCompany.getNationalInsuranceNumber())
		.append(phoneNumber, otherCompany.getPhoneNumber())
		.append(emailAddress, otherCompany.getEmailAddress())
		.append(address, otherCompany.getAddress())
		.append(bankAccount,otherCompany.getBankAccount())
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
			.append(nationalInsuranceNumber)
			.append(phoneNumber)
			.append(emailAddress)
			.append(address)
			.append(bankAccount)
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
		.append(nationalInsuranceNumber)
		.append(phoneNumber)
		.append(emailAddress)
		.append(address)
		.append(bankAccount)
		.toString();
	}

}
