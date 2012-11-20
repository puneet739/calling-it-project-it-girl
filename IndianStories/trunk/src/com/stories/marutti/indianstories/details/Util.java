package com.stories.marutti.indianstories.details;

/**
 * 
 * This is the base Util class which will be used to provide the details to us. 
 * @author puneetb
 *
 */
public class Util {

	private static Util mUtil;
	
	
	public static Util getInstance(){
		if (mUtil==null){
			return mUtil = new Util();
		}
		return mUtil;
	}
	
	
}

