package com.yoilLotto.round;

import java.util.HashMap;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface RoundService {

	public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception;
	
	public List<HashMap<String, Object>> selectSqlIdByVO(String sqlId, RoundVO vo)throws Exception;
	
}
