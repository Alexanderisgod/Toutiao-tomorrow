package com.neu.test;

import com.neu.dao.PasswordDao;
import com.neu.model.Password;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;

/**
 * @author ysy
 * @create 2020/7/10-21:44
 */
public class BPwdTest {
    @Test
    public void testInsertPwd()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        PasswordDao pwdDao=session.getMapper(PasswordDao.class);
        //3.使用代理对象执行方法
        pwdDao.addPwd(new Password(3,"123456"));
        //4.释放资源
        session.close();
    }
    @Test
    public void testDeleteById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        PasswordDao pwdDao=session.getMapper(PasswordDao.class);
        //3.使用代理对象执行方法
        pwdDao.deleteById(1);
        //4.释放资源
        session.close();
    }
    @Test
    public void getPwdById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        PasswordDao pwdDao=session.getMapper(PasswordDao.class);
        //3.使用代理对象执行方法
        Password p=pwdDao.getPwdById(3);
        System.out.println(p.getuId());
        //4.释放资源
        session.close();
    }
    @Test
    public void testUpdateById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        PasswordDao pwdDao=session.getMapper(PasswordDao.class);
        //3.使用代理对象执行方法
        HashMap map=new HashMap();
        pwdDao.updatePwdById(3,"66666");
        //4.释放资源
        session.close();
    }

}
