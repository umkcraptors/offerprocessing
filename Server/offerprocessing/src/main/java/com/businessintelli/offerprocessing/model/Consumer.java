package com.businessintelli.offerprocessing.model;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "CONSUMERS")
public class Consumer implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CONSUMERID")
	@GeneratedValue
	private int consumerId;
	
	@OneToOne
    @JoinColumn(name="MARKETERID")
	private int MarketerId;
	@Column(name = "Handle")
	private String Handle;
	@Column(name = "EMAIL")
	private String Email;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "MIDDLENAME")
	private String middleName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "STATUS")
	private char status;
	
	public Consumer() {
		
	}
	


	public Consumer(int consumerId, int marketerId, String handle, String email, String firstName, String middleName,
			String lastName, String phone, char status) {
		super();
		this.consumerId = consumerId;
		MarketerId = marketerId;
		Handle = handle;
		Email = email;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
		this.status = status;
	}



	public int getconsumerId() {
		return consumerId;
	}

	public void setconsumerId(int consumerId) {
		this.consumerId = consumerId;
	}

	public int getMarketerId() {
		return MarketerId;
	}

	public void setMarketerId(int marketerId) {
		MarketerId = marketerId;
	}

	public String getHandle() {
		return Handle;
	}

	public void setHandle(String handle) {
		Handle = handle;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public char getStatus() {
		return status;
	}

	public void setStatus(char status) {
		this.status = status;
	}
	

}
