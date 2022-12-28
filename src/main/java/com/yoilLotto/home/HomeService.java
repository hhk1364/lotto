package com.yoilLotto.home;

import java.util.HashMap;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface HomeService {

	public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception;
	
}
