package com.yoilLotto.api.web;

import java.util.HashMap;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface ApiService {

	public List<?> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception;
	
	public void insertSqlIdByHashMap(String sqlId, HashMap<String, Object> param) throws Exception;

}
