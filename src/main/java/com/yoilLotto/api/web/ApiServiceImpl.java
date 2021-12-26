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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yoilLotto.stats.web.StatsService;

@Service("ApiService")
public class ApiServiceImpl  implements ApiService{
	
	@Resource(name = "apiDAO")
	private ApiDAO apiDAO;
	
	@Override
	public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception{
		return apiDAO.selectSqlIdByHashMap(sqlId, param);
	}
	
	@Override
	public void insertSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception{
		apiDAO.insertSqlIdByHashMap(sqlId, param);
	}

}
