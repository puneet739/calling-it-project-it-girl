/**
 * Nov 20, 2012
 * 9:44:11 PM
 * puneetb
 */
package com.stories.marutti.indianstories.helper;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Story;

import android.util.SparseArray;

/**
 * @author puneetb
 * 
 */
public class Config {

	private static Config mConfig;
	private Map<Integer, Story> mStoryMap;
	InputStream storyStream; 
	Boolean loaded = false;
	
	

	private Config() {
	}

	public static Config getInstance() {
		if (mConfig == null) {
			mConfig = new Config();
		}
		return mConfig;
	}

	/**
	 * This function will load the XML into key value pair to memory.
	 */
	public void loadStories() {
		Document doc = XMLfunctions.XMLDocumentfromInputStream(getStoryStream());
		StoryKeyMapGenerator(doc);
	}

	
	private void StoryKeyMapGenerator(Document doc) {
		String categoryName;
		mStoryMap = new HashMap<Integer, Story>();

		NodeList nodes = doc
				.getElementsByTagName(Constants.XMLConstants_StoryMap.STORY);

		for (int numberofcategories = 0; numberofcategories < nodes.getLength(); numberofcategories++) {
			Element categoryElement = (Element) nodes.item(numberofcategories);

			String ID = XMLfunctions.getValue(categoryElement,
					Constants.XMLConstants_StoryMap.ID);

			String StoryTitle = XMLfunctions.getValue(categoryElement,
					Constants.XMLConstants_StoryMap.TITLE);

			String StoryPath = XMLfunctions.getValue(categoryElement,
					Constants.XMLConstants_StoryMap.FILEPATH);

			Log.dbg("Story ID is :: " + ID);
			Log.dbg("Story Tittle is :: " + StoryTitle);
			Log.dbg("Story Path is :: " + StoryPath);
			Story tempStory = new Story(StoryTitle);
			tempStory.setPath(StoryPath);
			tempStory.setStoryID(ID);
			
			mStoryMap.put(tempStory.getStoryID(), tempStory);
			
			Log.dbg("******************");
		}
		
	}
	
	
	public InputStream getStoryStream() {
		return storyStream;
	}

	public void setStoryStream(InputStream storyStream) {
		this.storyStream = storyStream;
	}
	
	public Story getStory(Integer storyId){
		return mStoryMap.get(storyId);
	}
	
	public Boolean getLoaded() {
		return loaded;
	}

	public void setLoaded(Boolean loaded) {
		this.loaded = loaded;
	}
	
}
