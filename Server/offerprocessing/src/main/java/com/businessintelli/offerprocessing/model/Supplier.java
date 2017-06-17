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
@Table(name = "SUPPLIER")
public class Supplier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8583208354004976749L;
	private int Supplierid; 
	private String Domain;
	private String	Suppliertype; 
	private String Name;
	private char Priority; 
	private char Isactive;
	
	public Supplier() {
		
	}

	public Supplier(int supplierid, String domain, String suppliertype, String name, char priority, char isactive) {
		
		Supplierid = supplierid;
		Domain = domain;
		Suppliertype = suppliertype;
		Name = name;
		Priority = priority;
		Isactive = isactive;
	}

	public int getSupplierid() {
		return Supplierid;
	}

	public void setSupplierid(int supplierid) {
		Supplierid = supplierid;
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public String getSuppliertype() {
		return Suppliertype;
	}

	public void setSuppliertype(String suppliertype) {
		Suppliertype = suppliertype;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public char getPriority() {
		return Priority;
	}

	public void setPriority(char priority) {
		Priority = priority;
	}

	public char getIsactive() {
		return Isactive;
	}

	public void setIsactive(char isactive) {
		Isactive = isactive;
	}

	@Override
	public String toString() {
		return "Supplier [Supplierid=" + Supplierid + ", Domain=" + Domain + ", Suppliertype=" + Suppliertype
				+ ", Name=" + Name + ", Priority=" + Priority + ", Isactive=" + Isactive + "]";
	} 
		 
	  
	  
	  


}
