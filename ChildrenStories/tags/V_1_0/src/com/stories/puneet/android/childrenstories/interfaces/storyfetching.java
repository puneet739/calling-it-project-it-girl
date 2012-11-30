/**
 * Nov 20, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.puneet.android.childrenstories.interfaces;

import java.util.List;

import com.stories.puneet.android.childrenstories.entity.Story;

/**
 * @author puneetb
 *
 */
public interface storyfetching {

	public String getStoriesbyStoryID(Integer storyId);
	
	public String getStoriesbyStoryID(Story story);
		
}
