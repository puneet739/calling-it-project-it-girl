/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories;

import java.util.ArrayList;
import java.util.List;

import com.stories.marutti.indianstories.adapters.StorySelectorListAdapter;
import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Categories;
import com.stories.marutti.indianstories.entity.Story;
import com.stories.marutti.indianstories.helper.CategoryHelper;
import com.stories.marutti.indianstories.helper.Config;
import com.stories.marutti.indianstories.helper.DummyData;
import com.stories.marutti.indianstories.interfaces.CategoryFetching;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * @author puneetb This class is used to display the List of stories available
 *         in that category.
 * 
 */
public class StorySelectorActivity extends ListActivity {

	List<Story> mStories = new ArrayList<Story>();
	ListView storyList;
	private Categories mCurrentCategory;
	private TextView title;
	Boolean loaded = false;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.dbg("Creating StorySelector Activity");
		setContentView(R.layout.storyselector);
		Bundle map = getIntent().getExtras().getBundle(Constants.BUNDLE);
		mCurrentCategory = (Categories) map.get(Constants.CATEGORY);

		iniliazlizeDetails();
	}

	public final Categories getCurrentCategory() {
		return mCurrentCategory;
	}

	public void iniliazlizeDetails() {
		title = (TextView) findViewById(R.id.storycategorytitle);
		title.setText(getCurrentCategory().getTitle());
		loadCategoryList();

		storyList = (ListView) findViewById(android.R.id.list);
		BaseAdapter storyAdapter = new StorySelectorListAdapter(
				getApplicationContext(), mStories);
		setListAdapter(storyAdapter);
		storyList.setOnItemClickListener((OnItemClickListener) storyAdapter);
	}

	/**
	 * This method is used to load the list<Stories> into the activity.
	 * 
	 * @see DummyData
	 * @see CategoryHelper
	 * @see CategoryFetching
	 */
	public void loadCategoryList() {
		loadStoriesMap();
		CategoryHelper helper = new CategoryHelper();
		mStories = helper.getStoriesbyCategory(getCurrentCategory());
	}

	private void loadStoriesMap() {
		try {
			if (Config.getInstance().getLoaded()==false){
				Log.dbg("***Loading Config need to called only ONCE***");
				Config mconfig = Config.getInstance();
				mconfig.setStoryStream(getAssets().open(Constants.FILES.STORY_MAP));
				mconfig.loadStories();
				mconfig.setLoaded(true);
			}
		} catch (Exception e) {
			Log.err("Exception caused while loading in loadStoriesMap()");
			e.printStackTrace();
		}
	}

}
