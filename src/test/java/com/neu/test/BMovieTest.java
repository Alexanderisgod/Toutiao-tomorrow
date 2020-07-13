package com.neu.test;

import com.neu.dao.MovieDao;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author ysy
 * @create 2020/7/11-23:09
 */
public class BMovieTest {
    @Test
    public void testgetMovieById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        MovieDao movieDao=session.getMapper(MovieDao.class);
        //3.使用代理对象执行方法
        System.out.println(movieDao.getMovieById(1));
        //4.释放资源
        session.close();
    }
}
