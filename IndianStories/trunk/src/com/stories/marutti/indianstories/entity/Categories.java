package com.stories.marutti.indianstories.entity;

import java.io.Serializable;

public class Categories implements Serializable{

	String mTitle;
	String mImage;
	
	public Categories(String Title){
		this.mTitle = Title;
	}
	
	public String getTitle() {
		return mTitle;
	}
	public void setTitle(String mTitle) {
		this.mTitle = mTitle;
	}
	public String getImage() {
		return mImage;
	}
	public void setImage(String mImage) {
		this.mImage = mImage;
	}

	@Override
	public String toString() {
		String details = "Categories:[Title:"+mTitle+" , mImage:"+mImage+"]";
		return details;
	}

}
