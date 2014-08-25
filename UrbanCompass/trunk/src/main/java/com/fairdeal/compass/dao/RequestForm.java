package com.fairdeal.compass.dao;

import java.util.Date;

import org.springframework.data.annotation.Id;

public class RequestForm {

	@Id
	private String id;
	private Date createDate;
	private String userName;
	private String phoneNumber;
	private String emailAddress;
	private String description;
	
	private String type; 
	private String desiredArea;
	
	private boolean closed;

	public static final String RENTAL="rental";
	public static final String PURCHASE="purchase";
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the desiredArea
	 */
	public String getDesiredArea() {
		return desiredArea;
	}
	/**
	 * @param desiredArea the desiredArea to set
	 */
	public void setDesiredArea(String desiredArea) {
		this.desiredArea = desiredArea;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RequestForm [id=" + id + ", createDate=" + createDate
				+ ", userName=" + userName + ", phoneNumber=" + phoneNumber
				+ ", emailAddress=" + emailAddress + ", description="
				+ description + ", type=" + type + ", desiredArea="
				+ desiredArea + ", closed=" + closed + "]";
	}
	public boolean isClosed() {
		return closed;
	}
	public void setClosed(boolean closed) {
		this.closed = closed;
	}


}
