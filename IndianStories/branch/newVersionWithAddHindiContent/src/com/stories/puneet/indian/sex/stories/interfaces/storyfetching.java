/**
 * Nov 20, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.puneet.indian.sex.stories.interfaces;

import java.util.List;

import com.stories.puneet.indian.sex.stories.entity.Story;

/**
 * @author puneetb
 *
 */
public interface storyfetching {

	public String getStoriesbyStoryID(Integer storyId);
	
	public String getStoriesbyStoryID(Story story);
		
}
