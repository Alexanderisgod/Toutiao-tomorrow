package com.neu.test;

import com.neu.dao.UserDao;
import com.neu.model.User;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author ysy
 * @create 2020/7/11-0:20
 */
public class BUserTest {
    @Test
    public void testaddUser()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        //3.使用代理对象执行方法
        User u=new User();
        u.setuId(2);u.setuName("bbb");u.setGender("男");
        userDao.addUser(u);
        //4.释放资源
        session.close();
    }
    @Test
    public void testgetUserById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        //3.使用代理对象执行方法
        User u=userDao.getUserById(2);
        System.out.println(u);
        //4.释放资源
        session.close();
    }
    @Test
    public void testdeleteUserById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        //3.使用代理对象执行方法
        userDao.deleteUserById(2);
        //4.释放资源
        session.close();
    }
    @Test
    public void testupdateUserById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        UserDao userDao=session.getMapper(UserDao.class);
        //3.使用代理对象执行方法

        //4.释放资源
        session.close();
    }
}
