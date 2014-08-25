package com.fairdeal.compass.repo.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.fairdeal.compass.cache.QueryCache;
import com.fairdeal.compass.dao.Listing;
import com.fairdeal.compass.generic.Constants;
import com.fairdeal.compass.repo.ListingRepository;
import com.fairdeal.compass.util.LoggerUtil;

/**
 * This class is used to get the listing used throughout the application.
 *  
 * @author puneetbehl
 */
@Repository
public class ListingRepositoryImpl implements ListingRepository{

	@Autowired
	MongoTemplate mongoTemplate;
	
	@Override
	public void saveListing(Listing listing) {
		LoggerUtil.debug("Saving the Listing now:: "+listing);
		mongoTemplate.save(listing);
	}

	@Override
	public List<Listing> getAll() {
		List<Listing> completeList = mongoTemplate.findAll(Listing.class);
		return completeList;
	}

	@Override
	public List<Listing> getAllNotExpired() {
		LoggerUtil.debug("Fetching the Listings which are not expired yet");
		Date currentDate = new Date();
		Query query = QueryCache.getInstance().getQuery("expiryDateQuery");
		if (query==null){
			query =new Query(Criteria.where(Constants.Listing.EXPIRY_DATE).lt(currentDate));
			QueryCache.getInstance().addQuery("expiryDateQuery", query);
		}
		List<Listing> completeList = mongoTemplate.find(query, Listing.class);
		return completeList;
	}

	@Override
	public List<Listing> getUserListing(int agentId) {
		Query query = QueryCache.getInstance().getQuery("userListing");
		if (query==null){
			query =new Query(Criteria.where(Constants.Listing.OWNER_ID).is(agentId));
			QueryCache.getInstance().addQuery("userListing", query);
		}
		List<Listing> completeList = mongoTemplate.find(query, Listing.class);
		return completeList;
	}

	@Override
	public Listing getListingById(String id) {
		Query query = QueryCache.getInstance().getQuery("getListingById");
		if (query==null){
			query =new Query(Criteria.where(Constants.Listing.LISTING_ID).is(id));
			QueryCache.getInstance().addQuery("getListingById", query);
		}
		Listing currentObject = mongoTemplate.findOne(query, Listing.class);
		return currentObject;
	}

}
