/**
 * Dec 6, 2012
 * 10:21:00 AM
 * puneetb
 */
package com.stories.puneet.android.childrenstories.LeadBolt;

import android.app.Activity;
import android.content.Context;

import com.pad.android.listener.AdListener;

/**
 * @author puneetb
 * 
 */
public class LeadBoltAdListener implements AdListener {

	Activity act;

	public LeadBoltAdListener(final Activity act) {
		this.act = act;
	}

	@Override
	public void onAdAlreadyCompleted() {
		act.finish();
	}

	@Override
	public void onAdClicked() {
	}

	@Override
	public void onAdClosed() {
		//act.finish();
	}

	@Override
	public void onAdCompleted() {
		act.finish();
	}

	@Override
	public void onAdFailed() {
		act.finish();
	}

	@Override
	public void onAdHidden() {
	}

	@Override
	public void onAdLoaded() {
	}

	@Override
	public void onAdPaused() {
		act.finish();
	}

	@Override
	public void onAdProgress() {
	}

	@Override
	public void onAdResumed() {

	}

}
