package com.stories.puneet.indian.sex.stories;

import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;

import com.adwhirl.AdWhirlLayout;
import com.adwhirl.AdWhirlLayout.AdWhirlInterface;
import com.adwhirl.AdWhirlManager;
import com.pad.android.iappad.AdController;
import com.stories.puneet.indian.sex.stories.adapters.MyGridAdapter;
import com.stories.puneet.indian.sex.stories.adapters.ProgramInitialingValues;
import com.stories.puneet.indian.sex.stories.details.Constants;
import com.stories.puneet.indian.sex.stories.details.Log;
import com.stories.puneet.indian.sex.stories.helper.AppRater;
import com.stories.puneet.indian.sex.stories.helper.Config;
import com.stories.puneet.indian.sex.stories.listeners.EndlessScrollListener;

public class MainActivity extends BaseActivity implements AdWhirlInterface {

	GridView gridview;
	BaseAdapter madapter;
	Context mContext;
	AdController myController;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		LoadBasicValues();
		setContentView(R.layout.categorylayout);
		initializeValues();
		gridview.setAdapter(madapter);
		

		AppRater.app_launched(this);
		
		//AdWhirlConfiguration(this);
		Log.dbg("Calling On create From MainActivity.");
	}

	/**
	 * This program is used to inilialize all the Ads  landing via AdWhirl platform 
	 * 
	 * @param mContext the context of the current activity. 
	 */
	
	/*
	private void AdWhirlConfiguration(Context  mContext) {

		AdWhirlManager.setConfigExpireTimeout(1000*60*5);

		
        AdWhirlLayout  adWhirlLayout = (AdWhirlLayout) findViewById(R.id.adwhirl_layout);

        RelativeLayout.LayoutParams layoutParams = new  RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);

        int diWidth = 320;
        int diHeight = 52;
        int density = getResources().getDisplayMetrics().densityDpi;
        adWhirlLayout.setAdWhirlInterface(this);
        adWhirlLayout.setMaxWidth((int)(diWidth * density));
        adWhirlLayout.setMaxHeight((int)(diHeight * density));
        layoutParams.addRule(RelativeLayout.CENTER_HORIZONTAL);

		
	}*/

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
		
		//Adding LeadBolt ApIcon
		Config.getInstance().AdLeadBolt(this, Constants.LEADBOLT.APP_ICON);
	}

	private void LoadBasicValues() {
		ProgramInitialingValues aSync = new ProgramInitialingValues(getApplicationContext());
		aSync.execute("Just Calling");
	}

	@Override
	public void adWhirlGeneric() {
		// TODO Auto-generated method stub
		
	}
}
