package com.study.mybatis.dao;

import com.study.mybatis.pojo.User;
import com.study.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    @Test
    public void test(){

        //第一步：获取SqlSession对象

        SqlSession sqlSession=MybatisUtils.getSqlSession();

        //getMapper
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        List<User> userList = userDao.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
    //关闭SqlSession
        sqlSession.close();
    }
}
