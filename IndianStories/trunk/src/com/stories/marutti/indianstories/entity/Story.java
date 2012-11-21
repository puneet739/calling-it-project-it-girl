package com.stories.marutti.indianstories.entity;

import java.io.Serializable;
import java.net.URL;
import java.util.List;

import com.stories.marutti.indianstories.details.Log;

import android.os.Parcelable;


/**
 * 
 * @author puneetb
 * Base Story Class. All the Class will extend this. 
 */

public class Story implements Serializable{
	
	URL mStoryURL;
	Integer mStoryID;
	String mPath;
	String mTitle;
	String mStory ="Strory Missing";
	String mImageUrl;
	List<String> mTags;
	List<Categories> mCategories;
	
	public Story(String title){
		this.mTitle = title;
	}

	public Integer getStoryID() {
		return mStoryID;
	}

	public void setStoryID(Integer mStoryID) {
		this.mStoryID = mStoryID;
	}
	
	public URL getStoryURL() {
		return mStoryURL;
	}

	public void setStoryURL(URL mStoryURL) {
		this.mStoryURL = mStoryURL;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}

	public String getStory() {
		return mStory;
	}

	public void setStory(String mStory) {
		this.mStory = mStory;
	}

	public String getImageUrl() {
		return mImageUrl;
	}

	public void setImageUrl(String mImageUrl) {
		this.mImageUrl = mImageUrl;
	}

	public List<String> getTags() {
		return mTags;
	}

	public void setTags(List<String> mTags) {
		this.mTags = mTags;
	}

	public List<Categories> getCategories() {
		return mCategories;
	}

	public void setCategories(List<Categories> mCategories) {
		this.mCategories = mCategories;
	}

	public String getPath() {
		return mPath;
	}

	public void setPath(String mPath) {
		this.mPath = mPath;
	}
	
	@Override
	public String toString() {
		String story = "Story [StoryID "+mStoryID+", Title: "+mTitle+", Path: "+mPath+"]";
		return story;
	}

	public void setStoryID(String iD) {
		try {
				Integer storyId = Integer.parseInt(iD);
				setStoryID(storyId);
		}catch(NumberFormatException e){
			Log.err("Number Parsing Exception. ");
			e.printStackTrace();
		}
		
	}	
	
}

