package com.yoilLotto.stats;

import java.util.HashMap;
import java.util.List;

public interface StatsService {

	public List<?> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception;

	public List<?> selectSqlIdByStatsVO(String sqlId, StatsVO vo) throws Exception;
	
}
