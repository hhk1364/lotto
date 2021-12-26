package com.yoilLotto.api.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import com.yoilLotto.api.web.ApiService;

import io.reactivex.annotations.SchedulerSupport;

@Component
public class ApiScheduler{
	
	@Autowired
	private ApiService apiService;
	
	// 로또 번호 저장하기
	public void batchRun() throws Exception{
		
		int drwNo = 0;
		
	    try {
	   		final HashMap<String, Object> param = new HashMap<String, Object>();
	    	// 로또 번호 테이블에서 마지막 로또 회차 조회
	    	List<HashMap> list= (List<HashMap>) apiService.selectSqlIdByHashMap("ApiDAO.selectMaxDrwNoLotto", param);
	    	drwNo = Integer.parseInt(list.get(0).get("drwNo").toString());
	    	// api 연결
	    	httpConnection(drwNo);
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        System.out.println(drwNo + "회차 API 연결 및 저장 성공");
	    }
		
	}
	
	
	// API 연결
	public void httpConnection(int drwNo) {
		   
			URL url = null;
		    HttpURLConnection conn = null;
		    String jsonData = "";
		    BufferedReader br = null;	 
		    StringBuilder sb = new StringBuilder();
		    JSONObject jsonLotto = null;
		    final HashMap<String, Object> param = new HashMap<String, Object>();
	   		String targetUrl = "";
		    
		    try {

		    	
			    targetUrl = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo=" + drwNo;
		    	
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
		        	
		        	param.put("drwNo", 			Integer.parseInt(String.valueOf(jsonLotto.get("drwNo"))));			
		        	param.put("returnValue", 	String.valueOf(jsonLotto.get("returnValue"))); 	
		        	param.put("totSellamnt", 	Double.parseDouble(String.valueOf(jsonLotto.get("totSellamnt")))); 	
		        	param.put("drwNoDate", 		String.valueOf(jsonLotto.get("drwNoDate"))); 		
		        	param.put("firstWinamnt", 	Double.parseDouble(String.valueOf(jsonLotto.get("firstWinamnt")))); 	
		        	param.put("firstPrzwnerCo", Double.parseDouble(String.valueOf(jsonLotto.get("firstPrzwnerCo")))); 	
		        	param.put("firstAccumamnt", Double.parseDouble(String.valueOf(jsonLotto.get("firstAccumamnt")))); 	
		        	param.put("drwtNo1", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo1")))); 		
		        	param.put("drwtNo2", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo2")))); 		
		        	param.put("drwtNo3", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo3")))); 		
		        	param.put("drwtNo4", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo4"))));		
		        	param.put("drwtNo5", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo5")))); 		
		        	param.put("drwtNo6", 		Integer.parseInt(String.valueOf(jsonLotto.get("drwtNo6")))); 		
		        	param.put("bnusNo",  		Integer.parseInt(String.valueOf(jsonLotto.get("bnusNo"))));  		
		        	
		        	apiService.insertSqlIdByHashMap("ApiDAO.insertLotto", param);
					
		        
		        }
		    	
		 
		    } catch (Exception e) {
		        e.printStackTrace();
		    } finally {
		        try {
		            if (br != null) br.close();
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		    }
		    
		}
	
	
}
