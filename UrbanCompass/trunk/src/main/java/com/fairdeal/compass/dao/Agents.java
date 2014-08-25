package com.fairdeal.compass.dao;

import java.util.Arrays;

/**
 * This is used to store the details of Users into application.
 * @author puneetbehl
 *
 */
public class Agents {

	private int agentId;
	private String name;
	private int phoneNumber;
	private String address;
	private String agentMainImage;
	private String[] agentDealImages;
	private String description;
	
	
	/**
	 * @return the agentId
	 */
	public int getAgentId() {
		return agentId;
	}
	/**
	 * @param agentId the agentId to set
	 */
	public void setAgentId(int agentId) {
		this.agentId = agentId;
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
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the agentMainImage
	 */
	public String getAgentMainImage() {
		return agentMainImage;
	}
	/**
	 * @param agentMainImage the agentMainImage to set
	 */
	public void setAgentMainImage(String agentMainImage) {
		this.agentMainImage = agentMainImage;
	}
	/**
	 * @return the agentDealImages
	 */
	public String[] getAgentDealImages() {
		return agentDealImages;
	}
	/**
	 * @param agentDealImages the agentDealImages to set
	 */
	public void setAgentDealImages(String[] agentDealImages) {
		this.agentDealImages = agentDealImages;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Agents [agentId=" + agentId + ", name=" + name
				+ ", phoneNumber=" + phoneNumber + ", address=" + address
				+ ", agentMainImage=" + agentMainImage + ", agentDealImages="
				+ Arrays.toString(agentDealImages) + ", description="
				+ description + "]";
	}

	
}
