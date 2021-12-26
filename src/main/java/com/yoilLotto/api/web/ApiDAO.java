package com.yoilLotto.api.web;


import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
@Repository
public class ApiDAO {
 
    @Inject
	private SqlSession sqlSession;    
    
    public List<HashMap<String, Object>> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param) throws Exception {
 
        return sqlSession.selectList(sqlId, param);
        
    }

    public void insertSqlIdByHashMap(String sqlId, HashMap<String, Object> param) throws Exception {
    	 
        sqlSession.insert(sqlId, param);
    }
}
