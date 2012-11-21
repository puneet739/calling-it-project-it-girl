package com.stories.marutti.indianstories.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;

import com.stories.marutti.indianstories.R;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Categories;
import com.stories.marutti.indianstories.entity.Story;
import com.stories.marutti.indianstories.interfaces.CategoryFetching;
import com.stories.marutti.indianstories.interfaces.storyfetching;

/**
 * 
 * @author puneetb
 * This is used at inital level to get the dummy data in the Code. 
 * 
 */
public class DummyData implements CategoryFetching, storyfetching{
	
	public static DummyData mDummyData;
	
	public static DummyData getInstance(){
		return mDummyData = new DummyData();
	}

	public List<Categories> loadCategories(List<Categories> categoryList) {
		List<Categories> categories = new ArrayList<Categories>();
		for (int i=0; i<10; i++){
			Categories category = new Categories("Title ::: "+i);
			categoryList.add(category);
		}
		return categories;
	}

	public void loadExtraCategories(List<Categories> categoryList) {
		if (categoryList.size()>50) return;
		for (int i=0; i<4; i++){
			Categories category = new Categories("New Titless ::: "+i);
			categoryList.add(category);
		}
	}
	
	public void getStories(){
		
	}
	
	public List<Story> getStoriesbyCategory(String Category, InputStream stream) {
		List<Story> mStories = new ArrayList<Story>();
		for (int i=0; i<50; i++ ){
			Story story = new Story("Title :"+i);
			mStories.add(story);
		}
		return mStories;
	}

	public Bitmap getrandomImage(Context mContext) {
		Bitmap draw = null;
		InputStream is = null;
		try {
			is = mContext.getResources().getAssets().open("Images/categories/3.jpg");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		draw = BitmapFactory.decodeStream(is);
		
		return draw;
	}

	@Override
	public List<Categories> loadCategories(InputStream stream) {
		List<Categories> categories = new ArrayList<Categories>();
		for (int i=0; i<10; i++){
			Categories category = new Categories("Title ::: "+i);
			categories.add(category);
		}
		return categories;
	}

	@Override
	public List<Story> getStoriesbyCategory(Categories category) {
		Log.dbg("Called at getStorybyCategory(Category)");
		return null;
	}

	@Override
	public String getStoriesbyStoryID(Integer storyId) {
		
		return null;
	}

	public String getStoriesbyStoryID(Story story) {
		Integer storyId = story.getStoryID();
		return getStoriesbyStoryID(storyId);
		
	}
	
}
