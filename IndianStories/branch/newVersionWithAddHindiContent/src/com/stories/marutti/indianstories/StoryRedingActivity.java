/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories;

import java.io.InputStream;

import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Story;
import com.stories.marutti.indianstories.helper.DummyData;
import com.stories.marutti.indianstories.helper.StoryHelper;
import com.stories.marutti.indianstories.interfaces.storyfetching;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author puneetb
 * This class is used to display the Stories we have with us. 
 * 
 */
public class StoryRedingActivity extends BaseActivity{

	TextView mTitle,mcompleteStory;
	Story mCurrentStory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.storyreading);
		inilizaizeVariables();
		Bundle map = getIntent().getExtras().getBundle(Constants.BUNDLE);
		mCurrentStory = (Story) map.get(Constants.STORY);
		setStoryDetails(mCurrentStory);
		Log.dbg("Calling On create From this function. Reading");
	}

	private void setStoryDetails(Story currentStory) {
		loadStoryContent(currentStory);
		String title = currentStory.getTitle();
		String story = currentStory.getStory();
		mTitle.setText(title);
		if (story!=null)
		mcompleteStory.setText(story);
	}

	private void loadStoryContent(Story currentStory) {
		try{
			storyfetching helper = new StoryHelper(getApplicationContext());
			helper.getStoriesbyStoryID(currentStory);
		}catch(Exception e){
			Log.err("Some Exception is received... Need to fix ThIS");
			e.printStackTrace();
		}
		
	}

	public void inilizaizeVariables() {
		setTitle(R.string.app_name);
		mTitle = (TextView) findViewById(R.id.storytitle);
		mcompleteStory = (TextView) findViewById(R.id.completestory);
	}

	
}
