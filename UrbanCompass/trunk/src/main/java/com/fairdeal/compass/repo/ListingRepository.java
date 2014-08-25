package com.fairdeal.compass.repo;

import java.util.List;

import com.fairdeal.compass.dao.Listing;

public interface ListingRepository {

	public void saveListing(Listing listing);
	
	public List<Listing> getAll();
	
	public List<Listing> getAllNotExpired();
	
	public List<Listing> getUserListing(int agentId);
	
	public Listing getListingById(String id);
	
}
