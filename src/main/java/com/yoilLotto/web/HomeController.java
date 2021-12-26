package com.yoilLotto.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yoilLotto.stats.web.StatsService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		 
	@Resource(name = "StatsService")
	private StatsService statsService;
	
	@RequestMapping(value = "/home.do")
	public String goMainPage(HttpServletRequest request,
								 ModelMap model)throws Exception{
	
		
		//for(int drwNo = 957;drwNo<983;drwNo++) { httpConnection(drwNo); }
		 
		return "home";
	}
	
}
