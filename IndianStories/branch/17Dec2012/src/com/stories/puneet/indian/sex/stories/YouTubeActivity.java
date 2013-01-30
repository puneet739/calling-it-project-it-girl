/**
 * Jan 18, 2013
 * 12:23:47 PM
 * puneetb
 */
package com.stories.puneet.indian.sex.stories;

import com.stories.puneet.indian.sex.stories.details.Constants;
import com.stories.puneet.indian.sex.stories.details.Log;
import com.stories.puneet.indian.sex.stories.helper.Config;
import com.stories.puneet.indian.sex.stories.youtube.OpenYouTubePlayerActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

/**
 * @author puneetb
 *
 */
public class YouTubeActivity{
	
	public static void LaunchYouTube(Context context, String VideoId){
		if (VideoId==null){
			Log.err("Video ID is null, Not running the YouTubePlayer");
			Toast.makeText(Config.getInstance().getContext(), "Video Not specified with this Story", Toast.LENGTH_LONG).show();
			Config.getInstance().AdLeadBoltConfigured((Activity)context, Constants.LEADBOLT.APPWALL,10);
			return;
		}
		Intent lVideoIntent = new Intent(null, Uri.parse("ytv://"+VideoId), context, OpenYouTubePlayerActivity.class);
        context.startActivity(lVideoIntent);
	}
	

}
