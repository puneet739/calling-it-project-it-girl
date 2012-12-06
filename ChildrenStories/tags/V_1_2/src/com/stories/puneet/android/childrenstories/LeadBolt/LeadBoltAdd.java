package com.stories.puneet.android.childrenstories.LeadBolt;

import android.app.Activity;

import com.pad.android.iappad.AdController;
import com.stories.puneet.android.childrenstories.details.Constants;


public class LeadBoltAdd {

	private LeadBoltAdd leadBoltad; 
	public static LeadBoltAdd getInstance(){
		return new LeadBoltAdd();
	}
	
	
	public void showAppWall(final Activity act){
		AdController myController = new AdController(act,Constants.ADS.LEADBOLT_APPWALL, new LeadBoltAdListener(act));
		myController.loadAd();
	}
	
	public void showInterstitialAd(final Activity act){
		AdController myController = new AdController(act,Constants.ADS.LEADBOLT_INTERSTITIAL, new LeadBoltAdListener(act));
		myController.loadAd();
		myController.showAd();
	}
}
