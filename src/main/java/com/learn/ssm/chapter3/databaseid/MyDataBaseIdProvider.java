package com.learn.ssm.chapter3.databaseid;

import org.apache.ibatis.mapping.DatabaseIdProvider;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * 自定义DataBaseId 的映射规则 在mybatis-config.xml 中配置此databaseId就可以了
 * 在mapper.xml 文件中使用databaseid标签标注
     在默认规则下name 是驱动的名字 value是databaseid
     xml中配置的预警的id 可以一样但是databaseid 可以不一样
     当没有匹配到就用没有databaseid的那一个 如果还找不到就抛异常
     <databaseIdProvider type="DB_VENDOR">
     <property name="Oracle" value="oracle"/>
     <property name="MySQL" value="mysql"/>
     </databaseIdProvider>
 *
 * @author xuanyang
 */
public class MyDataBaseIdProvider implements DatabaseIdProvider {

    private Logger logger = Logger.getLogger(MyDataBaseIdProvider.class);
    private static final String ORACLE = "Oracle";
    private static final String MYSQL = "MySQL";

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
