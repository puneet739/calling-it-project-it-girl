/**
 * Nov 23, 2012
 * 12:33:46 PM
 * puneetb
 */
package com.stories.marutti.indianstories.adapters;

import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.helper.Config;

import android.content.Context;
import android.os.AsyncTask;

/**
 * @author puneetb
 *
 */
public class ProgramInitialingValues extends AsyncTask<String, Void, Void>{

	Context mContext;
	public ProgramInitialingValues(Context context) {
		this.mContext = context;
	}
	
	@Override
	protected Void doInBackground(String... params) {
		try{
			Config mconfig;
			mconfig = Config.getInstance();
			mconfig.Inilialize(mContext);
			mconfig.setStoryStream(mconfig.getAssetManager().open(Constants.FILES.STORY_MAP));
			mconfig.loadStories();
			mconfig.setLoaded(true);
		}catch(Exception e){
			e.printStackTrace();
			Log.err("Exception caused while inilizaing values.. Need to check this");
		}
		return null;
	}

}
