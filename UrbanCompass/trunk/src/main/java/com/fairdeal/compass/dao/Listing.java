package com.fairdeal.compass.dao;

import java.util.Date;

/**
 * This is the base listing class. It is used to display the details on Map. 
 * 
 * @author puneetbehl
 */
public class Listing {

	private String id;
	private String city;
	private String state;
	private String country;
	private Date createdDate;
	private Date expirtyDate;
	
	private CityCordinates cordinates;
	
	private String description;
	private int ownerId;
	
	private double price;

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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
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
	 * @return the ownerId
	 */
	public int getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(int ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the expirtyDate
	 */
	public Date getExpirtyDate() {
		return expirtyDate;
	}

	/**
	 * @param expirtyDate the expirtyDate to set
	 */
	public void setExpirtyDate(Date expirtyDate) {
		this.expirtyDate = expirtyDate;
	}

	/**
	 * @return the cordinates
	 */
	public CityCordinates getCordinates() {
		return cordinates;
	}

	/**
	 * @param cordinates the cordinates to set
	 */
	public void setCordinates(CityCordinates cordinates) {
		this.cordinates = cordinates;
	}
	
}
