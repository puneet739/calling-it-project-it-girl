/**
 * Nov 20, 2012
 * 3:09:43 PM
 * puneetb
 */
package com.stories.marutti.indianstories.helper;

import java.io.InputStream;


import android.content.res.AssetManager;

/**
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
	
	/**
	 * Use this to get the File from the asset folder. 
	 * @param path The path of the file in asset folder. 
	 * @return The file in inputstream format. 
	 */
	
	public InputStream getFile(String path, AssetManager aManager){
		InputStream stream = null;
		try{
			stream = aManager.open(path);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println(e);
		}
		return stream;
	}
}
