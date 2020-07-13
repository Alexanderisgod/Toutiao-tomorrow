package com.neu.test;

import com.neu.dao.RatingDao;
import com.neu.model.Rating;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author ysy
 * @create 2020/7/11-14:51
 */
public class BRatingTest {
    @Test
    public void testaddRating()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        RatingDao ratingDao=session.getMapper(RatingDao.class);
        //3.使用代理对象执行方法
        Rating r=new Rating(3,1,2, (float)6.6);
        ratingDao.addRating(r);
        //4.释放资源
        session.close();
    }
    @Test
    public void testgetRatingById()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        RatingDao ratingDao=session.getMapper(RatingDao.class);
        //3.使用代理对象执行方法
        HashMap map=new HashMap();
        map.put("mId",2);
        List<Rating> r= ratingDao.getRatingIF(map);
        for (Rating r1:r){
            System.out.println(r1.getRate());
        }
        //4.释放资源
        session.close();
    }

}
