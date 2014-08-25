package com.test.fairdeal.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.fairdeal.compass.util.Config;
import com.fairdeal.compass.util.LoggerUtil;
import com.test.fairdeal.TestBase;

public class ConfigTest extends TestBase{

	@Test
	public void doTestSetup(){
		LoggerUtil.debug("Starting the main test");
		String output = Config.getStrConfig("test.config", "defaultValue");
		assertEquals("This is from file", output);
		
		String output2 = Config.getStrConfig("test.config.default", "defaultValue");
		assertEquals("defaultValue", output2);
	}
	
}
