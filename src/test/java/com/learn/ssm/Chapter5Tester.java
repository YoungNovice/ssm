package com.learn.ssm;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.mapper.UserMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Chapter5Tester {

    Logger logger = Logger.getLogger(Chapter5Tester.class);

    /**
     * rowBounds 是对查询结果分页 性能不行 不要用
     */
    @Test
    public void testRowBounds() {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        RowBounds bounds = new RowBounds(0, 20);
        List<Role> roles = mapper.findByRowBounds("", "", bounds);
        logger.info("rowBounds" + roles);
    }

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
