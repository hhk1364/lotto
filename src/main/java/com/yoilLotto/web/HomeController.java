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
			
			result.get(0).put("totSellamntKoreanVer", NumberToKor(result.get(0).get("totSellamnt").toString()));
			result.get(0).put("firstWinamntKoreanVer", NumberToKor(result.get(0).get("firstWinamnt").toString()));
			result.get(0).put("firstAccumamntKoreanVer", NumberToKor(result.get(0).get("firstAccumamnt").toString()));
			
			model.addAttribute("result", result);
			
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
