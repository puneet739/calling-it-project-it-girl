/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.puneet.android.childrenstories.adapters;

import java.util.List;

import com.stories.puneet.android.childrenstories.StoryRedingActivity;
import com.stories.puneet.android.childrenstories.details.Constants;
import com.stories.puneet.android.childrenstories.details.Log;
import com.stories.puneet.android.childrenstories.entity.Story;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * @author puneetb
 *
 */
public class StorySelectorListAdapter extends BaseAdapter implements OnItemClickListener{
	private Context mContext;
	private List<Story> mStories;
	
	public StorySelectorListAdapter(Context mContext){
		this(mContext,null);
	}
	public StorySelectorListAdapter(Context applicationContext,	List<Story> Stories) {
		this.mContext = applicationContext;
		this.mStories = Stories;
	}
	@Override
	public int getCount() {
		return mStories.size();
	}

	@Override
	public Story getItem(int position) {
		return mStories.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView view = new TextView(mContext);
		view.setText(mStories.get(position).getTitle());
		view.setTextSize(Constants.STORY_TEXT_SIZE);
		return view;
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		
		Story story = getItem(position);
		Log.dbg("Current Story Selected is :"+story);
		Intent intent = new Intent(mContext,StoryRedingActivity.class);
		
		Bundle map = new Bundle();
		map.putSerializable(Constants.STORY, story);
		intent.putExtra(Constants.BUNDLE, map);
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);
	}

}
