package com.yoilLotto.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yoilLotto.round.RoundService;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		 
	@Autowired
	private RoundService roundService;
	
	@RequestMapping(value = "/home.do")
	public String goMainPage(HttpServletRequest request,
							 @RequestParam(value = "drwNo", required = false) String drwNo,
							 ModelMap model)throws Exception{
	
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			List<HashMap<String, Object>> result = roundService.selectSqlIdByHashMap("RoundDAO.selectDrwNoLotto", param);
			
			model.addAttribute("result", result);
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		 
		return "home";
	}
	
}
