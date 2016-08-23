package com.huisou.analysis.query;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * Created by jingyang on 16-6-16.
 */
public class Client {

    public static SqlSessionFactory getMysqlSqlSessionFactory() throws IOException {
        Reader reader = Resources.getResourceAsReader("conf/Configuration.xml");
        return new SqlSessionFactoryBuilder().build(reader);
    }

}
