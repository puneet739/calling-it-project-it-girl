package com.stories.marutti.indianstories.helper;

import java.util.ArrayList;
import java.util.List;

import com.stories.marutti.indianstories.entity.Categories;
import com.stories.marutti.indianstories.entity.Story;

public class CategoryHelper implements com.stories.marutti.indianstories.interfaces.CategoryFetching{

	@Override
	public List<Categories> loadCategories() {
		List<Categories> categories = new ArrayList<Categories>();
		for (int i=0; i<10; i++){
			Categories category = new Categories("CategoryHelper: Title ::: "+i);
			categories.add(category);
		}
		return categories;
	}

	@Override
	public List<Story> getStoriesbyCategory(String Category) {
		List<Story> mStories = new ArrayList<Story>();
		for (int i=0; i<50; i++ ){
			Story story = new Story("Title :"+i);
			mStories.add(story);
		}
		return mStories;
	}

}
