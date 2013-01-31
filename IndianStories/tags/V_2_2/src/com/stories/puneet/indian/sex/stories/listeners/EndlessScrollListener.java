package com.stories.puneet.indian.sex.stories.listeners;

import com.stories.puneet.indian.sex.stories.adapters.MyGridAdapter;
import com.stories.puneet.indian.sex.stories.details.Log;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.BaseAdapter;

public class EndlessScrollListener implements OnScrollListener {

    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;
    private BaseAdapter mAdapter;

    public EndlessScrollListener() {
    	
    }
    
    public EndlessScrollListener(int visibleThreshold) {
        this.visibleThreshold = visibleThreshold;
    }

    public EndlessScrollListener(BaseAdapter madapter) {
    	mAdapter = madapter;
	}

	@Override
    public void onScroll(AbsListView view, int firstVisibleItem,
            int visibleItemCount, int totalItemCount) {
		
		//This is the main responsible function
		OnScrollDefinedFunction(view,firstVisibleItem,visibleItemCount,totalItemCount);
        
    }

    private void OnScrollDefinedFunction(AbsListView view,int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    	if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            // I load the next page of gigs using a background task,
            // but you can call any function here.
            //new LoadGigsTask().execute(currentPage + 1);
        	Log.dbg("Reached the end of the file.. Loading new Values");
        	
        	//Commenting this has made this do nothing.. Just ending in this loop. 
        	//((MyGridAdapter)mAdapter).loadmoreCategories();
            loading = true;
            
        }
	}

	@Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
    }
    
	public void setAdapter(BaseAdapter mAdapter) {
		this.mAdapter = mAdapter;
	}
}


