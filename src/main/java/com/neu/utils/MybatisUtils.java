package com.neu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author ysy
 * @create 2020/7/9-12:57
 */
public class MybatisUtils {
    public static SqlSession getSqlSession()throws IOException {
        //1.读取配置文件
        InputStream in= Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建SqlSessionFactory工厂 一个
        //factory没关闭就一直存在
        SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
        SqlSessionFactory factory=builder.build(in);
        //3.使用工厂生产SqlSession对象 多个
        in.close();
        return factory.openSession(true);//自动提交事务
    }
}
