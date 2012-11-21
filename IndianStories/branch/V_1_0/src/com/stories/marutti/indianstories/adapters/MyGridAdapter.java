package com.stories.marutti.indianstories.adapters;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stories.marutti.indianstories.R;
import com.stories.marutti.indianstories.StorySelectorActivity;
import com.stories.marutti.indianstories.details.Constants;
import com.stories.marutti.indianstories.details.Log;
import com.stories.marutti.indianstories.entity.Categories;
import com.stories.marutti.indianstories.helper.CategoryHelper;
import com.stories.marutti.indianstories.helper.DummyData;
import com.stories.marutti.indianstories.helper.Util;
import com.stories.marutti.indianstories.interfaces.CategoryFetching;

public class MyGridAdapter extends BaseAdapter implements OnItemClickListener {

	private List<Categories> categoryList = new ArrayList<Categories>();
	private Context mContext;
	LayoutInflater mInflater;

	public LayoutInflater getInflater() {
		return mInflater;
	}

	public MyGridAdapter(Context applicationContext) {
		mContext = applicationContext;
		mInflater = (LayoutInflater) mContext
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		loadCategories();
	}

	@Override
	public int getCount() {
		return categoryList.size();
	}

	@Override
	public Object getItem(int position) {
		return categoryList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View viewBlock = convertView;
		if (viewBlock == null) {
			viewBlock = getInflater().inflate(R.layout.categoryview, null);
		}
		TextView text = (TextView) viewBlock.findViewById(R.id.categorytitle);
		text.setText(categoryList.get(position).getTitle());
		
		ImageView image = (ImageView) viewBlock.findViewById(R.id.categoryImage);
		//image.setImageBitmap(bm)
		image.setImageBitmap(DummyData.getInstance().getrandomImage(mContext));
		return viewBlock;
	}

	public void loadmoreCategories() {
		CategoryFetching categoryDetails = new CategoryHelper();
		categoryDetails.loadCategories(null);
		//DummyData.getInstance().loadExtraCategories(categoryList);
		notifyDataSetChanged();
	}

	public void loadCategories() {
		CategoryFetching categoryDetails = new CategoryHelper();
		InputStream categoryXml = Util.getInstance().getFile(Constants.FILES.CATEGORY_FILES, mContext.getAssets());
		categoryList = categoryDetails.loadCategories(categoryXml);
		//categoryList = DummyData.getInstance().loadCategories();
	}

	/**
	 * Use this to write the details on what Activity to launch when the
	 * Category is selected.
	 */
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,	long id) {
		Log.dbg("Item is clicked.. " + position);
		Log.dbg("The Category selected is " + categoryList.get(position));
		Categories currentCategory = (Categories) getItem(position);
		Intent intent = new Intent(mContext, StorySelectorActivity.class);
		
		Bundle map = new Bundle();
		map.putSerializable(Constants.CATEGORY, currentCategory);
		intent.putExtra(Constants.BUNDLE, map);
		
		intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		mContext.startActivity(intent);
	}

}
