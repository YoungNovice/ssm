package com.learn.ssm;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.mapper.UserMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Chapter5Tester {

    Logger logger = Logger.getLogger(Chapter5Tester.class);

    @Test
    public void testUserFirstName() {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int xuan = mapper.countUserByFirstName("name");
        logger.info("一共有"+xuan+"条信息");
    }

    @Test
    public void testRoleListAnnotaion() {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<Role> roles = mapper.findRolesByAnnotation("", "");
        logger.info(roles);
    }
}
