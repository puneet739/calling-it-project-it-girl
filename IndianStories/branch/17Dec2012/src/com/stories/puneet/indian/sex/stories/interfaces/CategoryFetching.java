/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.puneet.indian.sex.stories.interfaces;

import java.io.InputStream;
import java.util.List;

import com.stories.puneet.indian.sex.stories.entity.Categories;
import com.stories.puneet.indian.sex.stories.entity.Story;

/**
 * @author puneetb
 *
 */
public interface CategoryFetching {

	public List<Categories> loadCategories(InputStream stream); 
	
	public List<Story> getStoriesbyCategory(String Category, InputStream stream) ;
	
	public List<Story> getStoriesbyCategory(Categories category) ;
		
}
