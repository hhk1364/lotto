package com.yoilLotto.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.http.HttpServletRequest;
import org.json.JSONObject;
import java.util.HashMap;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		 
	@RequestMapping(value = "/home.do")
	public String goMainPage(HttpServletRequest request,
								 ModelMap model)throws Exception{
	
		httpConnection("");
		
		return "home";
	}
		
	
	// 로또 번호 받아서 저장하기
	public String httpConnection(String targetUrl) {
	    URL url = null;
	    HttpURLConnection conn = null;
	    String jsonData = "";
	    BufferedReader br = null;	 
	    StringBuilder sb = new StringBuilder();
	    JSONObject jsonLotto = null;
   		HashMap<String, Object> param = new HashMap<String, Object>();

	    targetUrl = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=903";
	    
	    try {
	        url = new URL(targetUrl);
	 
	        conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-Type", "application/json");
	        conn.setRequestProperty("Accept-Charset", "UTF-8");
	        conn.setConnectTimeout(999999);
	        conn.setReadTimeout(999999);
	        conn.connect();
	 
	        br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
	 	 
	        while ((jsonData = br.readLine()) != null) {
	        	sb.append(jsonData);
	        	
	        	jsonLotto = new JSONObject(sb.toString());
	        	
	        	param.put("drwNo", 			jsonLotto.get("drwNo")); 			
	        	param.put("returnValue", 	jsonLotto.get("returnValue")); 	
	        	param.put("totSellamnt", 	jsonLotto.get("totSellamnt")); 	
	        	param.put("drwNoDate", 		jsonLotto.get("drwNoDate")); 		
	        	param.put("firstWinamnt", 	jsonLotto.get("firstWinamnt")); 	
	        	param.put("firstPrzwnerCo", 	jsonLotto.get("firstPrzwnerCo")); 	
	        	param.put("firstAccumamnt", 	jsonLotto.get("firstAccumamnt")); 	
	        	param.put("drwtNo1", 		jsonLotto.get("drwtNo1")); 		
	        	param.put("drwtNo2", 		jsonLotto.get("drwtNo2")); 		
	        	param.put("drwtNo3", 		jsonLotto.get("drwtNo3")); 		
	        	param.put("drwtNo4", 		jsonLotto.get("drwtNo4"));		
	        	param.put("drwtNo5", 		jsonLotto.get("drwtNo5")); 		
	        	param.put("drwtNo6", 		jsonLotto.get("drwtNo6")); 		
	        	param.put("bnusNo",  		jsonLotto.get("bnusNo"));  		
	        	
				//List<String, String> list = mapService.selectSqlIdByHashMap(sqlId, param);
	        
	        }
	 
	    } catch (IOException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (br != null) br.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    return "";
	}

}
