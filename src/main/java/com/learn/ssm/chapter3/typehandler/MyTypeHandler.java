package com.learn.ssm.chapter3.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 * 当用package 方式配置TypeHandler 时需要用注解告知Type 和 JdbcType
 *
 * @author young
 */
//@MappedTypes()
//@MappedJdbcTypes()
public class MyTypeHandler implements TypeHandler<String> {

    Logger logger = Logger.getLogger(MyTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, String param, JdbcType jdbcType) throws SQLException {
        logger.info("设置String 参数" + param);
        preparedStatement.setString(i, param);
    }

    @Override
    public String getResult(ResultSet resultSet, String columnName) throws SQLException {
        String result = resultSet.getString(columnName);
        logger.info("读取 String 参数1" + result);
        return result;
    }

    @Override
    public String getResult(ResultSet resultSet, int colnumIndex) throws SQLException {
        String result = resultSet.getString(colnumIndex);
        logger.info("读取 String 参数2" + result);
        return result;
    }

    @Override
    public String getResult(CallableStatement callableStatement, int cloumnIndex) throws SQLException {
        String result = callableStatement.getString(cloumnIndex);
        logger.info("读取 String 参数3" + result);
        return result;
    }
}
