package com.fairdeal.compass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairdeal.compass.util.LoggerUtil;

@Controller
public class RootController extends BaseController{

	
	
	@RequestMapping(value="/test")
	public String firstPage(){
		LoggerUtil.debug("This has reachessd the page RootController.firstPage()");
		return "firstPage";
	}
	
	
	@RequestMapping(value="/urban")
	public String testUrban(){
		LoggerUtil.debug("This has reachessd the page RootController.firstPage()");
		return "UrbanPage";
	}
	
	
	@RequestMapping(value="/main")
	public String testMain(){
		LoggerUtil.debug("This has reachessd the page RootController.firstPage()");
		return "main";
	}
	
	
}
