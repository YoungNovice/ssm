package com.learn.ssm;

import com.learn.ssm.chapter3.mapper.RoleMapper;
import com.learn.ssm.chapter3.mapper2.RoleMapper2;
import com.learn.ssm.chapter3.pojo.Role;
import com.learn.ssm.chapter3.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

public class Chapter3Tester {

    Logger log = Logger.getLogger(Chapter3Tester.class);


    @Test
    public void testRoleMapper1() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role role = roleMapper.getRole(2L);
            log.info(role.getRoleName()+role.getNote());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void testRoleMapper2() {
        SqlSession sqlSession = null;
        try {
            sqlSession = SqlSessionFactoryUtils.openSqlSession();
            RoleMapper2 roleMapper2 = sqlSession.getMapper(RoleMapper2.class);
            com.learn.ssm.chapter3.pojo2.Role role = roleMapper2.getRole(2L);
            log.info(role.getRoleName()+role.getNote());
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
