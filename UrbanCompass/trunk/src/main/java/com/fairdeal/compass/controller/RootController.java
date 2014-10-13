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
	
	
	@RequestMapping(value="/home")
	public String mainPage(){
		LoggerUtil.debug("This has reachessd the page RootController.firstPage()");
		return "main";
	}
	
	@RequestMapping(value="/agents")
	public String agentsPage(){
		LoggerUtil.debug("Here we are fetching all the agent Details and displaying agent details");
		return "agent";
	}
	
	
}
