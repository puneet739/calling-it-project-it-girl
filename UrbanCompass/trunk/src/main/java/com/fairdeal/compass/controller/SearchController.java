package com.fairdeal.compass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairdeal.compass.generic.Constants;
import com.fairdeal.compass.util.LoggerUtil;

/**
 * This is main controller used to search the Application core to find how many listing we have in our DB. 
 * 
 * @author puneetbehl
 */
@Controller
public class SearchController {

	@RequestMapping(value="/search")
	public String doSearch(){
		LoggerUtil.debug("Now in search function. This is used to fetch the listings we have and display them in map.");
		
		return Constants.RedirectPages.MAPPINGAREA;
	}
}
