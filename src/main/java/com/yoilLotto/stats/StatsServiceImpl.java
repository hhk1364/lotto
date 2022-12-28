package com.yoilLotto.stats;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yoilLotto.stats.StatsService;

@Service("StatsService")
public class StatsServiceImpl  implements StatsService{
	
	@Resource(name = "statsDAO")
	private StatsDAO statsDAO;
	
	@Override
	public List<?> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception{
		return statsDAO.selectSqlIdByHashMap(sqlId, param);
	}
	
	@Override
	public List<?> selectSqlIdByStatsVO(String sqlId, StatsVO vo)throws Exception{
		return statsDAO.selectSqlIdByStatsVO(sqlId, vo);
	}
	
	

}
