package com.yoilLotto.stats;


import java.util.HashMap;
import java.util.List;
import javax.inject.Inject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
 
@Repository
public class StatsDAO {
 
    @Inject
    private SqlSession sqlSession;
        
    public List<?> selectSqlIdByHashMap(String sqlId, HashMap<String, Object> param) throws Exception {
 
        return sqlSession.selectList(sqlId, param);
        
    }
    
    public List<?> selectSqlIdByStatsVO(String sqlId, StatsVO vo) throws Exception {
    	 
        return sqlSession.selectList(sqlId, vo);
        
    }
    

}
