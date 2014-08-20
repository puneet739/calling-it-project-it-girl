package com.fairdeal.compass.controller;

import java.util.LinkedList;
import java.util.List;

import com.fairdeal.compass.dao.CityCordinates;
import com.fairdeal.compass.dao.Listing;

public class BaseController {

	// 28.4792083, 77.310794
	double latitute = 28.4792083;
	double longitute = 77.310794;

	public List<Listing> getListing() {
		List<Listing> listing = new LinkedList<>();
		for (int i = 0; i < 50; i++) {
			Listing tempList = new Listing();
			CityCordinates cordinates = new CityCordinates();
			cordinates.setLatitude(latitute);
			cordinates.setLongitude(longitute);
			latitute = latitute + 0.0000080;
			longitute = longitute + 0.0000080;

			tempList.setCordinates(cordinates);
			tempList.setDescription("This is Listing number :: " + i);
			listing.add(tempList);
		}
		return listing;
	}
}
