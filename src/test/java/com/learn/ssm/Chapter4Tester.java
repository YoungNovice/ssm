package com.learn.ssm;

import com.learn.ssm.chapter3.mapper.UserMapper;
import com.learn.ssm.chapter3.pojo.User;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Chapter4Tester {

    Logger logger = Logger.getLogger(Chapter4Tester.class);

    @Test
    public void testUserEnumTypeHandler(){
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.getUser(1L);
        logger.info(user.getSex().getName());

    }

}
