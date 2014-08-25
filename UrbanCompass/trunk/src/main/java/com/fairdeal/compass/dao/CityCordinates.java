package com.fairdeal.compass.dao;

/**
 * This is used to store the city Cordinates of particular area.
 * 
 * @author puneetbehl
 */
public class CityCordinates {
	
	private String cityName;
    private double latitude;
    private double longitude;
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}
	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}
	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CityCordinates [cityName=" + cityName + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
    
    
}
