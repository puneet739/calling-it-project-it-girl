/**
 * Nov 20, 2012
 * 9:44:11 PM
 * puneetb
 */
package com.stories.puneet.android.childrenstories.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.stories.puneet.android.childrenstories.details.Constants;
import com.stories.puneet.android.childrenstories.details.Log;
import com.stories.puneet.android.childrenstories.entity.Story;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * @author puneetb
 * 
 */
public class Config {

	private static Config mConfig;
	private Map<Integer, Story> mStoryMap;
	InputStream storyStream; 
	Boolean loaded = false;
	
	private Context mContext;
	private AssetManager mAssetManager;
	private Bitmap mDefaultImage;
	
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

	
	public Context getContext() {
		return mContext;
	}

	private void setContext(Context mContext) {
		this.mContext = mContext;
	}

	public AssetManager getAssetManager() {
		return mAssetManager;
	}

	private void setAssetManager(AssetManager mAssetManager) {
		this.mAssetManager = mAssetManager;
	}

	/**
	 * This fucntion is iniliazed at the start of the APP,
	 * Then the context and AssetManager of the app is stored here. 
	 * This should not  be changed from anywhere else. 
	 *  
	 * @param context 	The application context.
	 */
	public void Inilialize(Context context) {
		try{
		this.mContext = context;
		this.mAssetManager = context.getAssets();
		setDefaultImage(Constants.FILES.DEFAULT_IMAGE_PATH);
		Log.dbg("Application Context and AssetManager taken into cache Memory");
		Log.dbg("This need to be called only Once. ");
		}catch(Exception e){
			Log.err("Excetption casused while caching the iniliazize");
			e.printStackTrace();
		}
	}
	
	public Bitmap getDefaultImage() {
		return mDefaultImage;
	}

	private void setDefaultImage(String DefaultImagePath) {
		InputStream is = null;
		try {
			is = Config.getInstance().getAssetManager().open(DefaultImagePath);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		mDefaultImage = BitmapFactory.decodeStream(is);
	}
	
}
