package com.yoilLotto.stats;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.yoilLotto.stats.StatsService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class StatsController {
		 
	@Autowired
	private StatsService statsService;
	
	// 번호 통계
	@RequestMapping(value = "/stats/numberStats.do")
	public String goNumberStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectNumberStats", statsVO);
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);
			List<HashMap<String, Object>> drwNoDateList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoDateList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(drwNoList.size()-1).get("drwNo").toString());
			}
			if(statsVO.getDrwNoDateStart() == null) {
				statsVO.setDrwNoDateStart(drwNoDateList.get(0).get("drwNoStartMin").toString());
			}
			if(statsVO.getDrwNoDateEnd() == null) {
				statsVO.setDrwNoDateEnd(drwNoDateList.get(0).get("drwNoStartMax").toString());
			}
			
			model.addAttribute("result", result);
			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/numberStats";
	}
	
	// 구간별 통계
	@RequestMapping(value = "/stats/sectionStats.do")
	public String goSectionStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectSectionStats", statsVO);
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);
			List<HashMap<String, Object>> drwNoDateList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoDateList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(drwNoList.size()-1).get("drwNo").toString());
			}
			if(statsVO.getDrwNoDateStart() == null) {
				statsVO.setDrwNoDateStart(drwNoDateList.get(0).get("drwNoStartMin").toString());
			}
			if(statsVO.getDrwNoDateEnd() == null) {
				statsVO.setDrwNoDateEnd(drwNoDateList.get(0).get("drwNoStartMax").toString());
			}
			
			model.addAttribute("result", result);
			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/sectionStats";
	}
	
	// 홀짝 통계
	@RequestMapping(value = "/stats/oddEvenStats.do")
	public String goOddEvenStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectOddEvenStats", statsVO);
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);
			List<HashMap<String, Object>> drwNoDateList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoDateList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(drwNoList.size()-1).get("drwNo").toString());
			}
			if(statsVO.getDrwNoDateStart() == null) {
				statsVO.setDrwNoDateStart(drwNoDateList.get(0).get("drwNoStartMin").toString());
			}
			if(statsVO.getDrwNoDateEnd() == null) {
				statsVO.setDrwNoDateEnd(drwNoDateList.get(0).get("drwNoStartMax").toString());
			}
			
			model.addAttribute("result", result);
			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/oddEvenStats";
	}
	
	// 번호 합 통계
	@RequestMapping(value = "/stats/sumNumberStats.do")
	public String goSumNumberStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			String average = "";
			Double tmp = 0.0;
			Integer sum = 0;
			
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectSumNumberStats", statsVO);
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);
			List<HashMap<String, Object>> drwNoDateList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoDateList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(drwNoList.size()-1).get("drwNo").toString());
			}
			if(statsVO.getDrwNoDateStart() == null) {
				statsVO.setDrwNoDateStart(drwNoDateList.get(0).get("drwNoStartMin").toString());
			}
			if(statsVO.getDrwNoDateEnd() == null) {
				statsVO.setDrwNoDateEnd(drwNoDateList.get(0).get("drwNoStartMax").toString());
			}
			
			if(result.size() > 0) {
				
				for(int i=0; i<result.size(); i++) {
					sum += Integer.parseInt(result.get(i).get("sum").toString());
				}
				
				tmp = (double) ((double) sum / (double) result.size());
				
				average = String.format("%.2f", tmp);
				
			}
			
			model.addAttribute("average", average);
			model.addAttribute("result", result);
			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/sumNumberStats";
	}
	
}
