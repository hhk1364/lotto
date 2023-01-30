package com.yoilLotto.home;

import org.json.JSONArray;
import org.json.JSONObject;
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
import javax.servlet.http.HttpSession;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
		 
	@Autowired
	private HomeService homeService;
	
	@RequestMapping(value = "/home.do")
	public String goMainPage(HttpServletRequest request,
							 @RequestParam(value = "drwNo", required = false) String drwNo,
							 ModelMap model, HttpSession session)throws Exception{
	
		HashMap<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			List<HashMap<String, Object>> result = homeService.selectSqlIdByHashMap("RoundDAO.selectDrwNoLotto", param);
			
			// 당첨 판매점(전체)
			List<HashMap<String, Object>> storeResultTmp = homeService.selectSqlIdByHashMap("RoundDAO.selectDrwNoLottoStore", param);
			
			// 당첨 판매점(1등)
			param.put("grade","1");
			List<HashMap<String, Object>> storeFirstResultTmp = homeService.selectSqlIdByHashMap("RoundDAO.selectDrwNoLottoStoreGrade", param);

			// 당첨 판매점(2등)
			param.put("grade","2");
			List<HashMap<String, Object>> storeSecondResultTmp = homeService.selectSqlIdByHashMap("RoundDAO.selectDrwNoLottoStoreGrade", param);

			JSONArray storeResult = new JSONArray();
			JSONArray storeFirstResult = new JSONArray();
			JSONArray storeSecondResult = new JSONArray();

			//해당 리스트 for문으로 jsonarray에 담기
			for(HashMap<String,Object> c : storeResultTmp) {
				//json 객체 생성
				JSONObject allStore = new JSONObject ();

				allStore.put("drwNo",c.get("drwNo"));
				allStore.put("grade",c.get("grade"));
				allStore.put("seq",c.get("seq"));
				allStore.put("storeNm",c.get("storeNm"));
				allStore.put("gb",c.get("gb"));
				allStore.put("address",c.get("address"));

			    //만들어진 하나의 json 객체 담기
				storeResult.put(allStore);
			}
			
			//해당 리스트 for문으로 jsonarray에 담기
			for(HashMap<String,Object> c : storeFirstResultTmp) {
				//json 객체 생성
				JSONObject allStore = new JSONObject ();

				allStore.put("drwNo",c.get("drwNo"));
				allStore.put("grade",c.get("grade"));
				allStore.put("seq",c.get("seq"));
				allStore.put("storeNm",c.get("storeNm"));
				allStore.put("gb",c.get("gb"));
				allStore.put("address",c.get("address"));

			    //만들어진 하나의 json 객체 담기
				storeFirstResult.put(allStore);
			}
					
			//해당 리스트 for문으로 jsonarray에 담기
			for(HashMap<String,Object> c : storeSecondResultTmp) {
				//json 객체 생성
				JSONObject allStore = new JSONObject ();

				allStore.put("drwNo",c.get("drwNo"));
				allStore.put("grade",c.get("grade"));
				allStore.put("seq",c.get("seq"));
				allStore.put("storeNm",c.get("storeNm"));
				allStore.put("gb",c.get("gb"));
				allStore.put("address",c.get("address"));

			    //만들어진 하나의 json 객체 담기
				storeSecondResult.put(allStore);
			}
			
			
			result.get(0).put("totSellamntKoreanVer", NumberToKor(result.get(0).get("totSellamnt").toString()));
			result.get(0).put("firstWinamntKoreanVer", NumberToKor(result.get(0).get("firstWinamnt").toString()));
			result.get(0).put("firstAccumamntKoreanVer", NumberToKor(result.get(0).get("firstAccumamnt").toString()));
			
			model.addAttribute("result", result);
			
			model.addAttribute("storeResultTmp", storeResultTmp);
			model.addAttribute("storeFirstResultTmp", storeFirstResultTmp);
			model.addAttribute("storeSecondResultTmp", storeSecondResultTmp);
		
			
			model.addAttribute("storeResult", storeResult);
			model.addAttribute("storeFirstResult", storeFirstResult);
			model.addAttribute("storeSecondResult", storeSecondResult);
			
			
		}catch (Exception e) {
	        e.printStackTrace();
	    }
		 
		return "home";
	}
	
	
    public String NumberToKor(String amt){
        
        String amt_msg = "";
        String[] arrayNum = {"", "일","이","삼","사","오","육","칠","팔","구"};
        String[] arrayUnit = {"","십 ","백 ","천 ","만 ","십만 ","백만 ","천만 ","억 ","십억 ","백업 ","천억 ","조 ","십조 ","백조 ","천조 ","경 ","십경 ","백경 ","천경 ","해 ","십해 ","백해 ","천해 "};
   
        if(amt.length() > 0){
            int len = amt.length();
            
            String[] arrayStr = new String[len];
            String hanStr = "";
            String tmpUnit = "";
            for(int i = 0; i < len; i++){
                arrayStr[i] = amt.substring(i, i+1);
            }
            int code = len;
            for(int i = 0; i < len; i++){
                code--;
                tmpUnit = "";
                if(arrayNum[Integer.parseInt(arrayStr[i])] != ""){
                    tmpUnit = arrayUnit[code];
                    if(code > 4){
                        if((Math.floor(code/4) == Math.floor((code-1)/4) 
                        && arrayNum[Integer.parseInt(arrayStr[i+1])] != "") ||
                        (Math.floor(code/4) == Math.floor((code-2)/4)
                        && arrayNum[Integer.parseInt(arrayStr[i+2])] != "")) {
                            tmpUnit = arrayUnit[code].substring(0,1);
                        }
                    }
                }
                hanStr += arrayNum[Integer.parseInt(arrayStr[i])]+tmpUnit;
            }
            amt_msg = hanStr;
        }else{
            amt_msg = amt;
        }
     
        return amt_msg;
    }
	
	
}
