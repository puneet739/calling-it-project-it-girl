package com.fairdeal.compass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fairdeal.compass.util.LoggerUtil;

@Controller
public class RootController {

	@RequestMapping(value="/test")
	public String firstPage(){
		LoggerUtil.debug("This has reachessd the page RootController.firstPage()");
		return "firstPage";
	}
}
