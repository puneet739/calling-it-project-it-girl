package com.fairdeal.core.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Base entity Object for creating new Agent. 
 * 
 * @author puneetb
 *
 */
@Entity
@Table(name="AGENT")
public class Agent implements Serializable{

	private static final long serialVersionUID = -6294378258877811646L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="id", nullable=false)
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="CreatedDate")
	private Date createdDate;
	
	@Column(name="PhoneNumber")
	private String phoneNumber;

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
