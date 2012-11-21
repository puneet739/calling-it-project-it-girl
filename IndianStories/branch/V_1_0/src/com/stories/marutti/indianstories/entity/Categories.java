package com.stories.marutti.indianstories.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.stories.marutti.indianstories.details.Log;

public class Categories implements Serializable{

	String mTitle;
	String mImage;
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
	public String getImage() {
		return mImage;
	}
	public void setImage(String mImage) {
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

	public void addStory(String storyId) {
		try{
		int StoryID = Integer.parseInt(storyId);
		addStory(StoryID);
		}catch(NumberFormatException ne){
			Log.err("Story ID cant be a alphanumeric. ");
			Log.err("Number Format Exception occured. ");
			ne.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

}
