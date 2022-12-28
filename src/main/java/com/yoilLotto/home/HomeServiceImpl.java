package com.yoilLotto.home;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("HomeService")
public class HomeServiceImpl  implements HomeService{
	
	@Resource(name = "homeDAO")
	private HomeDAO homeDAO;
	
	@Override
	public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception{
		return homeDAO.selectSqlIdByHashMap(sqlId, param);
	}
	

}
