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

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
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

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
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

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
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

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
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
	
	// 자동 수동 통계
	@RequestMapping(value = "/stats/autoNumberStats.do")
	public String goAutoNumberStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> result = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectAutoNumberStats", statsVO);
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
			}
			
			model.addAttribute("result", result);
			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/autoNumberStats";
	}
	
	// 지역별 통계
	@RequestMapping(value = "/stats/areaStats.do")
	public String goAreaStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> resultFirst = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectAreaStatsFirst", statsVO);
			List<HashMap<String, Object>> resultSecond = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectAreaStatsSecond", statsVO);
			
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
			}
			
			model.addAttribute("resultFirst", resultFirst);
			model.addAttribute("resultSecond", resultSecond);

			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/areaStats";
	}
	
	// 판매점 통계
	@RequestMapping(value = "/stats/storeStats.do")
	public String goStoreStatsPage(HttpServletRequest request,
									@ModelAttribute("StatsVO") StatsVO statsVO,
									ModelMap model)throws Exception{
			
			HashMap<String, Object> param = new HashMap<String, Object>();
		
			List<HashMap<String, Object>> resultFirst = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectStoreStatsFirst", statsVO);
			List<HashMap<String, Object>> resultSecond = (List<HashMap<String, Object>>) statsService.selectSqlIdByStatsVO("StatsDAO.selectStoreStatsSecond", statsVO);
			
			List<HashMap<String, Object>> drwNoList = (List<HashMap<String, Object>>) statsService.selectSqlIdByHashMap("StatsDAO.selectDrwNoList", param);

			if(statsVO.getDrwNoStart() == null) {
				statsVO.setDrwNoStart("1");
			}
			if(statsVO.getDrwNoEnd() == null) {
				statsVO.setDrwNoEnd(drwNoList.get(0).get("drwNo").toString());
			}
			
			model.addAttribute("resultFirst", resultFirst);
			model.addAttribute("resultSecond", resultSecond);

			model.addAttribute("statsVO", statsVO);
			model.addAttribute("drwNoList", drwNoList);
			
		 
		return "/stats/storeStats";
	}
	
}
