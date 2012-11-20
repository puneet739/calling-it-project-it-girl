/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories;

import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.entity.Story;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * @author puneetb
 * This class is used to display the Stories we have with us. 
 * 
 */
public class StoryRedingActivity extends Activity{

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
	}

	private void setStoryDetails(Story currentStory) {
		String title = currentStory.getTitle();
		String story = currentStory.getStory();
		mTitle.setText(title);
		if (story!=null)
		mcompleteStory.setText(story);
	}

	public void inilizaizeVariables() {
		mTitle = (TextView) findViewById(R.id.storytitle);
		mcompleteStory = (TextView) findViewById(R.id.completestory);
	}

	
}
