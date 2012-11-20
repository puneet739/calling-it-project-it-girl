/**
 * Nov 19, 2012
 * puneetb
 * The file is added by PuneetBehl
 */
package com.stories.marutti.indianstories.interfaces;

import java.util.List;

import com.stories.marutti.indianstories.entity.Categories;
import com.stories.marutti.indianstories.entity.Story;

/**
 * @author puneetb
 *
 */
public interface CategoryFetching {

	public List<Categories> loadCategories(); 
	
	public List<Story> getStoriesbyCategory(String Category) ;
	
		
}
