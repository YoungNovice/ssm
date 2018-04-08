package com.learn.ssm.chapter3.typehandler;

import com.learn.ssm.chapter3.enumeration.SexEnum;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.apache.ibatis.type.TypeHandler;
import org.apache.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedTypes(SexEnum.class)
@MappedJdbcTypes(JdbcType.INTEGER)
public class SexEnumTypeHandler implements TypeHandler<SexEnum>{

    Logger logger = Logger.getLogger(SexEnumTypeHandler.class);

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        logger.info("性别设置值");
        preparedStatement.setInt(i, sexEnum.getId());
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, String colName) throws SQLException {
        int id = resultSet.getInt(colName);
        logger.info("性别获取值");
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getResult(ResultSet resultSet, int colIndex) throws SQLException {
        int id = resultSet.getInt(colIndex);
        logger.info("性别获取值");
        return SexEnum.getSexById(id);
    }

    @Override
    public SexEnum getResult(CallableStatement callableStatement, int colIndex) throws SQLException {
        int anInt = callableStatement.getInt(colIndex);
        logger.info("性别获取值");
        return SexEnum.getSexById(anInt);
    }
}
