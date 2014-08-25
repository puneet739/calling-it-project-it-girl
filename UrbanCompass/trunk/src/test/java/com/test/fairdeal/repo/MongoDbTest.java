package com.test.fairdeal.repo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.fairdeal.compass.dao.Listing;
import com.fairdeal.compass.util.LoggerUtil;
import com.test.fairdeal.TestBase;

public class MongoDbTest extends TestBase{

	MongoTemplate template;
	
	
	@Test
	public void doFirstTest(){
		LoggerUtil.debug("This is my first Test function");
		
	}
	
	@Test
	public void saveObject(){
		Listing listing = new Listing();
		listing.setCity("City 1");
		listing.setCountry("India");
		template.save(listing);
		
		Query query = new Query(Criteria.where("city").is("City 1"));
		Listing list =  template.findOne(query, Listing.class);
		
		LoggerUtil.debug("Listing fetched from DB is ::: "+list);
		
		assertEquals(list.getCity(), listing.getCity());
		
		LoggerUtil.debug("Now droping the table");
		template.dropCollection(Listing.class);
	}
	
	
	

	@Override
	public void setUp() {
		super.setUp();
		template = getMongoTemplate();
	}
	
	
}
