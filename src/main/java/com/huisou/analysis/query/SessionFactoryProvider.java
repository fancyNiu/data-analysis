package com.huisou.analysis.query;

import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;

/**
 * Created by jingyang on 16-6-23.
 */
public enum SessionFactoryProvider {
    SESSION_FACTORY_PROVIDER;
    private SqlSessionFactory sqlSessionFactory;

    SessionFactoryProvider() {
        try {
             sqlSessionFactory = Client.getMysqlSqlSessionFactory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}
