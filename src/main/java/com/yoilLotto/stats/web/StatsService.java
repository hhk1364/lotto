package com.yoilLotto.stats.web;

import java.util.HashMap;
import java.util.List;

public interface StatsService {

	public List<?> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception;
	
	public void insertSqlIdByHashMap(String sqlId, HashMap<String, Object> param) throws Exception;

	
}
