package com.fairdeal.compass.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairdeal.compass.generic.Constants;
import com.fairdeal.compass.util.LoggerUtil;
import com.fairdeal.compass.util.Util;

/**
 * This is main controller used to search the Application core to find how many listing we have in our DB. 
 * 
 * @author puneetbehl
 */
@Controller
public class SearchController extends BaseController{

	@RequestMapping(value="/search")
	public String doSearch(Model model){
		LoggerUtil.debug("Now in search function. This is used to fet ch the listings we have and display them in map.");
		List list = getListing();
		LoggerUtil.debug("Josn List is :: "+Util.convertJavaObjectToJson(getListing()));
		model.addAttribute(Constants.GenericConstants.LISTING,Util.convertJavaObjectToJson(getListing()) );
		
		return Constants.RedirectPages.MAPPINGAREA;
	}
}
