package com.stories.puneet.indian.sex.stories.helper;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.stories.puneet.indian.sex.stories.details.Constants;
import com.stories.puneet.indian.sex.stories.details.Log;
import com.stories.puneet.indian.sex.stories.entity.Categories;
import com.stories.puneet.indian.sex.stories.entity.Story;

public class CategoryHelper implements
		com.stories.puneet.indian.sex.stories.interfaces.CategoryFetching {

	@Override
	public List<Categories> loadCategories(InputStream stream) {
		List<Categories> categories = new ArrayList<Categories>();

		Document documnet = XMLfunctions.XMLDocumentfromInputStream(stream);

		//XMLDataParser parser = new XMLDataParser();
		try {
			categories = CategoryGenerator(documnet);

		} catch (Exception e) {
			for (int i = 0; i < 10; i++) {
				Categories category = new Categories("DUMMYTitle ::: " + i);
				categories.add(category);
			}
		}
		return categories;
	}

	@Override
	public List<Story> getStoriesbyCategory(Categories category) {
		List<Story> mStories = new ArrayList<Story>();
		
		List<Integer> storyId = category.getStories();
		Iterator<Integer> itr = storyId.iterator();
		while(itr.hasNext()){
			mStories.add(Config.getInstance().getStory(itr.next()));
		}
		return mStories;
	}
	
	@Override
	public List<Story> getStoriesbyCategory(String Category, InputStream stream) {
		List<Story> mStories = new ArrayList<Story>();
		for (int i = 0; i < 50; i++) {
			Story story = new Story("CategoryHelper Title :" + i);
			mStories.add(story);
		}
		return mStories;
	}

	
	
	/**
	 * This is the base function which converts the XML to the Objects.
	 * @param doc	The Document format of the XML.
	 * @return		The List of categories which need to be manupulated in the system. 
	 */
	private List<Categories> CategoryGenerator(Document doc) {
		List<Categories> categoryList = new ArrayList<Categories>();
		String categoryName;
		NodeList nodes = doc.getElementsByTagName(Constants.XMLConstants.CATEGORY);

		for (int numberofcategories = 0; numberofcategories < nodes.getLength(); numberofcategories++) {

			Element categoryElement = (Element) nodes.item(numberofcategories);

			String name = XMLfunctions.getValue(categoryElement,
					Constants.XMLConstants.NAME);

			if (name == null) {
				continue;
			}
			
			Categories tempCategory = new Categories(name);

			String imagepath = XMLfunctions.getValue(categoryElement,
					Constants.XMLConstants.IMAGEPATH);
			
			tempCategory.setImage(imagepath);
			
			NodeList stories = categoryElement
					.getElementsByTagName(Constants.XMLConstants.STORIES);

			for (int numberofStories = 0; numberofStories < stories.getLength(); numberofStories++) {

				Element storiesElement = (Element) stories
						.item(numberofStories);

				NodeList storyid = storiesElement
						.getElementsByTagName(Constants.XMLConstants.STORYID);

				for (int p = 0; p < storyid.getLength(); p++) {
					//Element storyElement = (Element) storyid.item(p);

					//String storyID = XMLfunctions.getValue(storyElement,
					//		Constants.XMLConstants.STORYID);

					//String storyID2 = XMLfunctions.getValue(storiesElement,
					//		Constants.XMLConstants.STORYID);
					String StoryId = XMLfunctions.getElementValue(storyid.item(p));
					tempCategory.addStory(StoryId);
					Log.dbg("StoryId in above Category is :: " + StoryId);
				}
			}
			categoryList.add(tempCategory);
			Log.dbg("******************");
		}

		return categoryList;
	}

	
}
