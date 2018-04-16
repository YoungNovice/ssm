package com.learn.ssm;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

public class Chapter5Tester {

    Logger logger = Logger.getLogger(Chapter5Tester.class);

    @Test
    public void testInsertRow() {
        Role role = new Role();
        role.setRoleName("aaa");
        role.setNote("aaa 是一个好人");

        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        try {
            mapper.insertRole(role);
            session.commit();
        } catch (Exception e) {
            session.rollback();
            e.printStackTrace();
        }
    }

    /**
     * rowBounds 是对查询结果分页 性能不行 不要用
     */
    @Test
    public void testRowBounds() {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        RowBounds bounds = new RowBounds(0, 20);
//        List<Role> roles = mapper.findByRowBounds("", "", bounds);
//        logger.info("rowBounds" + roles);
    }


    @Test
    public void testRoleListAnnotaion() {
        SqlSession session = SqlSessionFactoryUtils.openSqlSession();
        RoleMapper mapper = session.getMapper(RoleMapper.class);
        List<Role> roles = mapper.findRolesByAnnotation("", "");
        logger.info(roles);
    }
}
