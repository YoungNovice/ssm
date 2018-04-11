package com.learn.ssm.chapter3.datasource;

import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.ibatis.datasource.DataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.util.Properties;

/**
 *
 * @author Young
 * @date 2018/4/9
 */
public class MyDataSourceFactory implements DataSourceFactory {

    private Properties properties;

    Logger logger = Logger.getLogger(MyDataSourceFactory.class);

    @Override
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public DataSource getDataSource() {
        try {
            logger.info("使用dbcp数据源工厂");
            return BasicDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
