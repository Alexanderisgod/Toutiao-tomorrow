package com.neu.test;

import com.neu.dao.UserRecommendDao;
import com.neu.model.Movie;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author ysy
 * @create 2020/7/11-15:36
 */
public class BUserRecommendTest {
    @Test
    public void testgetMoiveByUserId()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        UserRecommendDao URDao=session.getMapper(UserRecommendDao.class);
        //3.使用代理对象执行方法
        List<Movie> m=URDao.getMovieByUserId(1);
        for(Movie m1:m){
            System.out.println(m1);
        }
        //4.释放资源
        session.close();
    }
}
