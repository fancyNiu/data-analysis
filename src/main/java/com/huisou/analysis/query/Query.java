package com.huisou.analysis.query;

import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by jingyang on 16-6-30.
 */
public class Query {
    public List query(String table,Map<String, String> params) {
        List queryResultList = new ArrayList();
        try(SqlSession session = SessionFactoryProvider.SESSION_FACTORY_PROVIDER.getSqlSessionFactory().openSession()){
            String confId = "config.mapping.Mapper.Get"+table+"Data";
            queryResultList = session.selectList(confId,params);
        }
        return queryResultList;
    }
}
