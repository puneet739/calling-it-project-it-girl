package com.stories.puneet.android.childrenstories.entity;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.stories.puneet.android.childrenstories.details.Log;
import com.stories.puneet.android.childrenstories.helper.Config;

public class Categories implements Serializable{

	String mTitle;
	transient Bitmap mImage;
	List<Integer> mStories = new ArrayList<Integer>();
	
	public Categories(String Title){
		this.mTitle = Title;
	}
	
	public String getTitle() {
		return mTitle;
	}
	
	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	
	public Bitmap getImage() {
		if (mImage==null){
			mImage = Config.getInstance().getDefaultImage();
		}
		return mImage;
	}
	
	public void setImage(Bitmap mImage) {
		this.mImage = mImage;
	}

	public void addStory(Integer storyId){
		mStories.add(storyId);
	}
	
	public List<Integer> getStories() {
		return mStories;
	}
	
	@Override
	public String toString() {
		String details = "Categories:[Title:"+mTitle+" , mImage:"+mImage+" ,Stories:"+mStories+" ]";
		return details;
	}

	/**
	 * Call this to add storyID to the category.
	 * The passed value should be a number.  
	 * @param storyId
	 */
	public void addStory(String storyId) {
		try{
		int StoryID = Integer.parseInt(storyId);
		addStory(StoryID);
		}catch(NumberFormatException ne){
			Log.err("Story ID cant be a alphanumeric. ");
			Log.err("Number Format Exception occured. ");
			ne.printStackTrace();
		}
	}

	/**
	 * Use this to add some default image to the category view. 
	 * If nothing is provided, the system will set the default category Image.
	 * @param imagePath 	Path of the image in the asset folder. 
	 */
	public void setImage(String imagePath) {
		InputStream is = null;
		Bitmap image = null;
		try {
			is = Config.getInstance().getAssetManager().open(imagePath);
			image = BitmapFactory.decodeStream(is);
			
		} catch (FileNotFoundException e) {
			Log.wrn("Image for Category is not defined/Found in the system. Will use default Image. "+e.getLocalizedMessage());
		} catch(Exception e){
			Log.err("Some Different Exception occured. "+e.getLocalizedMessage());
			e.printStackTrace();
		}
		mImage = image;
		
	}

}
