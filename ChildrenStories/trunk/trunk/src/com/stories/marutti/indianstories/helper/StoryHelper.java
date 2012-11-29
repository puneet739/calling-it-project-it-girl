/**
 * Nov 21, 2012
 * 12:44:05 PM
 * puneetb
 */
package com.stories.marutti.indianstories.helper;

import java.io.InputStream;

import android.content.Context;

import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Story;
import com.stories.marutti.indianstories.interfaces.storyfetching;

/**
 * @author puneetb
 *
 */
public class StoryHelper implements storyfetching{

	Context mContext;
	
	public StoryHelper(Context applicationContext) {
		this.mContext = applicationContext;
	}

	@Override
	public String getStoriesbyStoryID(Integer storyId) {
		//Not implimented. Still under observation
		return null;
	}

	public String getStoriesbyStoryID(Story story) {
		Integer storyId = story.getStoryID();
		String storyPath = story.getPath();
		String Story= "Failed Story";
		try{
		InputStream is  = mContext.getAssets().open(storyPath);
		Story = TextFileReading.parseStream(is);
		}catch(Exception e){
			Log.err("Exception is caused.. You made a mistake");
			e.printStackTrace();
		}
		story.setStory(Story);
		return Story;
	}

}
