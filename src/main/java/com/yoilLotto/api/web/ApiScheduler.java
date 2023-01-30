package com.yoilLotto.api.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletContext;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.yoilLotto.api.web.ApiService;
import org.openqa.selenium.support.ui.*;

@Component
public class ApiScheduler{
	
    @Autowired
    private ServletContext context;
	
	@Autowired
	private ApiService apiService;
	
	//드라이버 ID
    @Value("${api.WEB_DRIVER_ID}")
	public String WEB_DRIVER_ID; 
    
    //드라이버 경로   
    @Value("${api.WEB_DRIVER_PATH}")
    public String WEB_DRIVER_PATH;
    
    // 회차 당첨정보 api 타겟 url 경로
    @Value("${api.targetUrl}")
    public String apiTargetUrl;

    // 회차 당첨판매점 api 타겟 url 경로
    @Value("${api.targetStoreUrl}")
    public String apiTargetStoreUrl;
    
	// 로또 번호 저장하기
	public void batchRun() throws Exception{
		
		int drwNo = 0;
		
   		HashMap<String, Object> param = new HashMap<String, Object>();
    	
   		// 수동 배치
   		//while(drwNo < 1053) {
   		
   		// 로또 번호 테이블에서 마지막 로또 회차 조회
    	List<HashMap<String, Object>> list= apiService.selectSqlIdByHashMap("ApiDAO.selectMaxDrwNoLotto", param);
    	drwNo = Integer.parseInt(list.get(0).get("drwNo").toString());
    	httpConnection(drwNo);    	
    	getStore(drwNo);
   		//}

    	//번호별 통계 테이블 전체 삭제
        System.out.println("번호별 통계 테이블 전체 삭제 시작");
    	apiService.deleteSqlIdByHashMap("ApiDAO.deleteStatsNumberTable", param);
        System.out.println("번호별 통계 테이블 전체 삭제 종료");

    	// 번호별 통계 테이블 insert
        System.out.println("번호별 통계 테이블 insert 시작");
    	apiService.insertSqlIdByHashMap("ApiDAO.insertStatsNumberTable", param);
        System.out.println("번호별 통계 테이블 insert 종료");
   		

	}
	
	
	// API 연결
	public void httpConnection(int drwNo) {
		   
			URL url = null;
		    HttpURLConnection conn = null;
		    String jsonData = "";
		    BufferedReader br = null;	 
		    StringBuilder sb = new StringBuilder();
		    JSONObject jsonLotto = null;
		    HashMap<String, Object> param = new HashMap<String, Object>();
	   		String targetUrl = "";
		    
		    try {

		    	
			    targetUrl = apiTargetUrl + drwNo;
		    	
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
		    	
		    	System.out.println(drwNo + "회차 API 연결 및 저장 성공");

		    } catch (Exception e) {
		       System.out.println(drwNo + "회 API 통신 실패");
		    } finally {
		        try {
		            if (br != null) br.close();
		        } catch (IOException e) {
				    System.out.println(drwNo + "회 API 통신 실패");
		        }
		    }
		    
		}
	
	
		// 당첨 판매점 가져오기
		public void getStore(int drwNo) {
			
			//드라이버 설정
			try {
				System.setProperty(WEB_DRIVER_ID, context.getRealPath(WEB_DRIVER_PATH));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			try {
				
				ChromeOptions options = new ChromeOptions();
	            options.addArguments("--disable-popup-blocking");
	            options.addArguments("--disable-default-apps");
	            options.addArguments("--disable-notifications");
	            options.addArguments("headless");
	            
	            //webdriver 객체생성
	            ChromeDriver driver = new ChromeDriver(options);

				//이동을 원하는 url
				String url = apiTargetStoreUrl;
				
				//WebDriver을 해당 url로 이동한다.
				driver.get(url);
				
				//브라우저 이동시 생기는 로드시간을 기다린다.
				//HTTP응답속도보다 자바의 컴파일 속도가 더 빠르기 때문에 임의적으로 1초를 대기한다.
				Thread.sleep(1000);

				// 초기데이터 만들기 start
				//for(int num=997; num<1049; num++) {
					
					// 회차 가져오기
					//int drwNo = num;
					
					Select ghlck = new Select(driver.findElement(By.id("drwNo")));
					ghlck.selectByValue(String.valueOf(drwNo));
					
					WebElement btn = driver.findElement(By.id("searchBtn"));
					btn.click();
					
					Thread.sleep(2000);
					

					//class="tbl_data" 인 모든 태그를 가진 WebElement리스트를 받아온다.
					//WebElement는 html의 태그를 가지는 클래스이다.
					List<WebElement> table = driver.findElements(By.className("tbl_data_col"));
					
					// 1등 당첨 판매점
					List<WebElement> firstTr = table.get(0).findElements(By.tagName("tr"));

					for (int i = 1; i < firstTr.size(); i++) {
						
						List<WebElement> td = firstTr.get(i).findElements(By.tagName("td"));
						
						HashMap<String, Object> param = new HashMap<String, Object>();
						
						param.put("drwNo", 			drwNo);			
			        	param.put("grade", 			1); 	
			        	param.put("seq", 			Integer.parseInt(td.get(0).getText().toString())); 	
			        	param.put("storeNm", 		td.get(1).getText().toString()); 		
			        	param.put("gb", 			td.get(2).getText().toString()); 	
			        	param.put("address", 		td.get(3).getText().toString()); 	
			        	
			        	apiService.insertSqlIdByHashMap("ApiDAO.insertStore", param);	
										
					}
					
					//페이지 갯수 가져오기
					WebElement pageList = driver.findElement(By.className("paginate_common"));
					List<WebElement> page = pageList.findElements(By.tagName("a"));

					for(int i=0; i<page.size(); i++) {
						
						pageList = driver.findElement(By.className("paginate_common"));
						page = pageList.findElements(By.tagName("a"));
						
						page.get(i).click();
						
						Thread.sleep(1000);

						// 2등 당첨 판매점
						table = driver.findElements(By.className("tbl_data_col"));

						List<WebElement> secondTr = table.get(1).findElements(By.tagName("tr"));

						for (int j = 1; j < secondTr.size(); j++) {
							
							List<WebElement> td = secondTr.get(j).findElements(By.tagName("td"));
								
							HashMap<String, Object> param = new HashMap<String, Object>();
							
							param.put("drwNo", 			drwNo);			
				        	param.put("grade", 			2); 	
				        	param.put("seq", 			Integer.parseInt(td.get(0).getText().toString())); 	
				        	param.put("storeNm", 		td.get(1).getText().toString()); 		
				        	param.put("gb", 			""); 	
				        	param.put("address", 		td.get(2).getText().toString()); 	
				        	
				        	apiService.insertSqlIdByHashMap("ApiDAO.insertStore", param);	
							
						}
					}
				// 초기데이터 만들기 end
				//}
				
				
				try {
					//드라이버가 null이 아니라면
					if(driver != null) {
						//드라이버 연결 종료
						driver.close(); //드라이버 연결 해제
						
						//프로세스 종료
						driver.quit();
					}
				} catch (Exception e) {
					throw new RuntimeException(e.getMessage());
				}
				
			}catch(Exception e) {
				System.out.println("당첨 판매점 크롤링 실패");
			}
			
			
			
		}
		
		
	
}
