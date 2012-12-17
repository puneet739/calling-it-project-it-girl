package com.stories.puneet.indian.sex.stories;

import android.app.Activity;
import android.content.ClipData.Item;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.stories.puneet.indian.sex.stories.adapters.MyGridAdapter;
import com.stories.puneet.indian.sex.stories.adapters.ProgramInitialingValues;
import com.stories.puneet.indian.sex.stories.details.Log;
import com.stories.puneet.indian.sex.stories.helper.Config;
import com.stories.puneet.indian.sex.stories.listeners.EndlessScrollListener;

public class MainActivity extends BaseActivity {

	GridView gridview;
	BaseAdapter madapter;
	Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LoadBasicValues();
		setContentView(R.layout.categorylayout);
		initializeValues();
		gridview.setAdapter(madapter);
		
		Log.dbg("Calling On create From MainActivity.");
	}

	/**
	 * @author puneetb This is used to initialize the variables and add all the
	 *         listeneres to the Views.
	 */
	private void initializeValues() {
		setTitle(R.string.app_name);
		gridview = (GridView) findViewById(R.id.mygridview);
		mContext = getApplicationContext();
		
		//Adding the GridAdapter in the current View. 
		madapter = new MyGridAdapter(mContext);
		
		EndlessScrollListener endlesslistnr = new EndlessScrollListener();
		endlesslistnr.setAdapter(madapter);
		
		//These listeners are added to our gridView. To make the system interactive.  
		gridview.setOnItemClickListener((OnItemClickListener) madapter);
		gridview.setOnScrollListener(endlesslistnr);
	}

	private void LoadBasicValues() {
		ProgramInitialingValues aSync = new ProgramInitialingValues(getApplicationContext());
		aSync.execute("Just Calling");
	}
}
