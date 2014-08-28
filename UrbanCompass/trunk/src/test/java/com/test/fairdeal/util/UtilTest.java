package com.test.fairdeal.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fairdeal.compass.dao.CityCordinates;
import com.fairdeal.compass.util.Util;
import com.test.fairdeal.TestBase;

public class UtilTest extends TestBase{

	Util util ; 
	
	@Test
	public void testCordinates(){
		String cityName = "Delhi";
		CityCordinates cordinates = util.getCityCordinatesFromDatabase(cityName);
		
		assertEquals(cityName, cordinates.getCityName());
		assertEquals("28.635308", ""+cordinates.getLatitude());
		assertEquals("77.22496", ""+cordinates.getLongitude());
	}
	
	@Test
	public void testCordinatesfromDatabase(){
		//Need to impliment this feature.
	}


	/* (non-Javadoc)
	 * @see com.test.fairdeal.TestBase#setUp()
	 */
	@Override
	public void setUp() {
		super.setUp();
		util = getContext().getBean(Util.class);
	}
}
