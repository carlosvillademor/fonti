/**
 * @author Carlos Fernandez
 *
 * @date 25 Jul 2009
 *
 */
package com.carlos.projects.billing.domain;

import java.util.Date;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

/**
 * 
 */
public class Client {

	private long id;
	
	private String firstName;
	
	private String lastName;
	
	private String idCardNumber;
	
	private Address address;
	
	private Long phoneNumber;
	
	private String emailAddress;
	
	private Date dateOfBirth;
	
	private String bankAccount;
	
	private String nationalInsuranceNumber;

	public Client () {
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the idCardNumber
	 */
	public String getIdCardNumber() {
		return idCardNumber;
	}

	/**
	 * @param idCardNumber the idCardNumber to set
	 */
	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
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
	 * @return the phoneNumber
	 */
	public Long getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Long phoneNumber) {
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
	 * @return the dateOfBirth
	 */
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Client)) {
			return false;
		}
		
		if (obj == this) {
			return true;
		}
		
		Client otherClient = (Client) obj;		
		return new EqualsBuilder()
			.append(id, otherClient.getId())
			.append(firstName, otherClient.getFirstName())
			.append(lastName, otherClient.getLastName())
			.append(idCardNumber, otherClient.getIdCardNumber())
			.append(address, otherClient.getAddress())
			.append(phoneNumber, otherClient.getPhoneNumber())
			.append(emailAddress, otherClient.getEmailAddress())
			.append(dateOfBirth, otherClient.getDateOfBirth())
			.append(bankAccount, otherClient.getBankAccount())
			.append(nationalInsuranceNumber, 
					otherClient.getNationalInsuranceNumber())
			.isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		return new HashCodeBuilder()
		.append(id)
		.append(firstName)
		.append(lastName)
		.append(idCardNumber)
		.append(address)
		.append(phoneNumber)
		.append(emailAddress)
		.append(dateOfBirth)
		.append(bankAccount)
		.append(nationalInsuranceNumber)
		.hashCode();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return new ToStringBuilder(this)
		.append(id)
		.append(firstName)
		.append(lastName)
		.append(idCardNumber)
		.append(address)
		.append(phoneNumber)
		.append(emailAddress)
		.append(dateOfBirth)
		.append(bankAccount)
		.append(nationalInsuranceNumber)
		.toString();
	}

}
