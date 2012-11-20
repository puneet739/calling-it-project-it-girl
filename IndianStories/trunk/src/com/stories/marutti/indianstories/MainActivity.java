package com.stories.marutti.indianstories;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;

import com.stories.marutti.indianstories.adapters.MyGridAdapter;
import com.stories.marutti.indianstories.listeners.EndlessScrollListener;

public class MainActivity extends Activity {

	GridView gridview;
	BaseAdapter madapter;
	Context mContext;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.categorylayout);
		initializeValues();
		gridview.setAdapter(madapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/**
	 * @author puneetb This is used to initialize the variables and add all the
	 *         listeneres to the Views.
	 */
	private void initializeValues() {
		gridview = (GridView) findViewById(R.id.mygridview);
		mContext = getApplicationContext();
		madapter = new MyGridAdapter(mContext);
		EndlessScrollListener endlesslistnr = new EndlessScrollListener();
		endlesslistnr.setAdapter(madapter);
		
		//These listeners are added to our gridView. To make the system interactive.  
		gridview.setOnItemClickListener((OnItemClickListener) madapter);
		gridview.setOnScrollListener(endlesslistnr);
	}

}
