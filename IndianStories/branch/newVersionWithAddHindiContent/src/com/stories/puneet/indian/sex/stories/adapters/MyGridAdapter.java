package com.stories.puneet.indian.sex.stories.adapters;

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

import com.stories.puneet.indian.sex.stories.R;
import com.stories.puneet.indian.sex.stories.StorySelectorActivity;
import com.stories.puneet.indian.sex.stories.details.Constants;
import com.stories.puneet.indian.sex.stories.details.Log;
import com.stories.puneet.indian.sex.stories.entity.Categories;
import com.stories.puneet.indian.sex.stories.helper.CategoryHelper;
import com.stories.puneet.indian.sex.stories.helper.DummyData;
import com.stories.puneet.indian.sex.stories.helper.Util;
import com.stories.puneet.indian.sex.stories.interfaces.CategoryFetching;

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
	public Categories getItem(int position) {
		return categoryList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View viewBlock = convertView;
		Categories currentCategory = getItem(position);
		if (viewBlock == null) {
			viewBlock = getInflater().inflate(R.layout.categoryview, null);
		}
		TextView text = (TextView) viewBlock.findViewById(R.id.categorytitle);
		text.setText(currentCategory.getTitle());
		
		ImageView image = (ImageView) viewBlock.findViewById(R.id.categoryImage);
		//image.setImageBitmap(bm)
		//image.setImageBitmap(DummyData.getInstance().getrandomImage(mContext));
		image.setImageBitmap(currentCategory.getImage());
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
