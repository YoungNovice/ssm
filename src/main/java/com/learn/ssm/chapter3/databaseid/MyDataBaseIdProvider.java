package com.learn.ssm.chapter3.databaseid;

import com.learn.ssm.chapter3.transaction.MyJdbcTransaction;
import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 自定义DataBaseId 的映射规则
 *
 * @author xuanyang
 */
public class MyDataBaseIdProvider implements DatabaseIdProvider{

    private Logger logger = Logger.getLogger(MyDataBaseIdProvider.class);
    public static final String ORACLE = "Oracle";
    public static final String MYSQL = "MySQL";


    @Override
    public void setProperties(Properties properties) {
        logger.info(properties);
    }

    @Override
    public String getDatabaseId(DataSource dataSource) throws SQLException {
        Connection connection = dataSource.getConnection();
        // 获取数据库的名字
        String name = connection.getMetaData().getDatabaseProductName();
        if (name == null || "".equals(name)) {
            return null;
        }
        if (name.equalsIgnoreCase(ORACLE)) {
            return "oracle";
        } else if (name.equalsIgnoreCase(MYSQL)) {
            return "mysql";
        } else {
            return name;
        }
    }
}
