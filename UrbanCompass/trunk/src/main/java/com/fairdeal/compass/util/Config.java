package com.fairdeal.compass.util;

import java.util.Iterator;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.FileConfiguration;
import org.apache.commons.configuration.PropertiesConfiguration;


/**
 * This class is used to read the configuration of the application.
 * 
 * @author puneetbehl
 */
public class Config {
	private static FileConfiguration config;

	public Config(String path) throws ConfigurationException{
		String workingDir = System.getProperty("user.dir");
		LoggerUtil.debug("Current working directory is "+workingDir);
		LoggerUtil.debug("The file name specified here is "+path);
		config = new PropertiesConfiguration(path);
	}

	public static String getStrConfig(String key, String defaultValue){
		return config.getString(key, defaultValue);
	}
	
	public static int getIntConfig(String key, int defaultValue){
		return config.getInt(key, defaultValue);
	}
	
	public static String[] getListConfig(String key){
		return config.getStringArray(key);
	}

	/**
	 * This method is used to print configuration settings loaded at this point
	 * of time. -- not used now.
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private void printConfiguration() {
		Iterator<String> allKeys = config.getKeys();
		while (allKeys.hasNext()) {
			String currentKey = allKeys.next();
			LoggerUtil.info(currentKey + "=" + config.getString(currentKey));
		}
	}
}
