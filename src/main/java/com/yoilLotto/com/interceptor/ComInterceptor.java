package com.yoilLotto.com.interceptor;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.yoilLotto.com.dao.ComDAO;

public class ComInterceptor extends HandlerInterceptorAdapter {
	
	@Resource(name = "comDAO")
	private ComDAO comDAO;    
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		HttpSession session = request.getSession();
		
		HashMap <String, Object> param = new HashMap<String, Object>();
		// 파라미터 설정
		param.put("requestURI", request.getRequestURI().toString());
		
		// 해당 메뉴 가져오기
		List<HashMap<String, Object>> selectMyMenu = comDAO.selectSqlIdByHashMap("comDAO.selectMyMenu", param);
		
		if(selectMyMenu.size() > 0) {
			session.setAttribute("myMenu", selectMyMenu); 
			session.setAttribute("allTopMenu", comDAO.selectSqlIdByHashMap("comDAO.selectAllTopMenu", param)); 
			session.setAttribute("myDownMenu", comDAO.selectSqlIdByHashMap("comDAO.selectMyDownMenu", param)); 
			session.setAttribute("myTopMenu", comDAO.selectSqlIdByHashMap("comDAO.selectMyTopMenu", param)); 
		}
		
		return true;

	}
	

}