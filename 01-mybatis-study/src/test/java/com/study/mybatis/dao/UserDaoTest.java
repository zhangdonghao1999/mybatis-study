package com.study.mybatis.dao;

import com.study.mybatis.pojo.User;
import com.study.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserDaoTest {
    //查询
    @Test
    public void test(){

        //第一步：获取SqlSession对象

        SqlSession sqlSession=MybatisUtils.getSqlSession();

        //方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //方式二：
        //List<User> userList = sqlSession.selectList("com.study.mybatis.dao.UserDao.getUserList");
        for (User user : userList) {
            System.out.println(user);
        }
    //关闭SqlSession
        sqlSession.close();
    }
    //根据ID查询用户
    @Test
    public void getUserById(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);
        System.out.println(userById);

        sqlSession.close();
    }

    //增删改需要提交事务  插入数据
    @Test
    public void addUser(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int  re = mapper.addUser(new User(4, "马六", "123456"));
            if (re>0){
                System.out.println("插入数据成功");
            }

            //提交事务
            sqlSession.commit();
        sqlSession.close();

    }

    //增删改需要提交事务  更新数据
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int up = mapper.updateUser(new User(4, "王七", "678900"));
                if (up>0){
                    System.out.println("更新数据成功");
                }
        sqlSession.commit();
        sqlSession.close();
    }

    //增删改需要提交事务  删除数据
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int i = mapper.deleteUser(1);
        if(i <= 0){
            System.out.println("删除数据成功.......");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}



