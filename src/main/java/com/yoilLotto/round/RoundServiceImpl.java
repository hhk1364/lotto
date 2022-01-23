package com.yoilLotto.round;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service("RoundService")
public class RoundServiceImpl  implements RoundService{
	
	@Resource(name = "roundDAO")
	private RoundDAO roundDAO;
	
	@Override
	public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param)throws Exception{
		return roundDAO.selectSqlIdByHashMap(sqlId, param);
	}
	

}
