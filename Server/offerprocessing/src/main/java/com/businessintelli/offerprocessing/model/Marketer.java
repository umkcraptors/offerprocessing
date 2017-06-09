package com.businessintelli.offerprocessing.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "MARKETER")
public class Marketer implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "MARKETERID")
	@GeneratedValue
	private int Id;
	@Column(name = "DOMAIN")
	private String Domain;
	@Column(name = "MARKETERTYPE")
	private String MarketerType;
	@Column(name = "NAME")
	private String Name;
	
	
	
	public Marketer() {
	
		
	}

	
	public Marketer(int Id, String Domain, String MarketerType, String Name) {
		
		this.Id = Id;
		this.Domain = Domain;
		this.MarketerType = MarketerType;
		this.Name = Name;
		
	}

	
	public int getId() {
		return Id;
	}


	public void setId(int id) {
		Id = id;
	}


	public String getDomain() {
		return Domain;
	}


	public void setDomain(String domain) {
		Domain = domain;
	}


	public String getMarketerType() {
		return MarketerType;
	}


	public void setMarketerType(String marketerType) {
		MarketerType = marketerType;
	}


	public String getName() {
		return Name;
	}


	public void setName(String name) {
		Name = name;
	}


	@Override
	public String toString() {
		return "Marketer [Id=" + Id + ", Domain=" + Domain + ", MarketerType=" + MarketerType + ", Name=" + Name + "]";
	}


	
}

