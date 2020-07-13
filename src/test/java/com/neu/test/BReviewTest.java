package com.neu.test;

import com.neu.dao.ReviewDao;
import com.neu.model.Review;
import com.neu.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @author ysy
 * @create 2020/7/11-11:24
 */
public class BReviewTest {
    @Test
    public void testaddReview()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        ReviewDao reviewDao=session.getMapper(ReviewDao.class);
        //3.使用代理对象执行方法
        String string = "2016-10-24";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date d=new Date(sdf.parse(string).getTime());
        Review r=new Review(1,1,2,d,"很好",(float) 8.9,0);
        reviewDao.addReview(r);
        //4.释放资源
        session.close();
    }
    @Test
    public void testupdateReview()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        ReviewDao reviewDao=session.getMapper(ReviewDao.class);
        //3.使用代理对象执行方法

        //4.释放资源
        session.close();
    }
    @Test
    public void testgetReviewIF()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        ReviewDao reviewDao=session.getMapper(ReviewDao.class);
        //3.使用代理对象执行方法
        HashMap map=new HashMap();
        map.put("mId",2);
        List<Review> r= reviewDao.getReviewIF(map);
        for (Review r1:r){
            System.out.println(r1);
        }
        //4.释放资源
        session.close();
    }
    @Test
    public void testgetReviewSort()throws Exception{
        //1.获得SqlSession对象
        SqlSession session= MybatisUtils.getSqlSession();
        //2.使用session创建Dao接口的代理对象
        ReviewDao reviewDao=session.getMapper(ReviewDao.class);
        //3.使用代理对象执行方法
        HashMap map=new HashMap();
        map.put("mId",2);
        map.put("rTime",0);
        List<Review> r= reviewDao.getReviewSort(map);
        for (Review r1:r){
            System.out.println(r1);
        }
        //4.释放资源
        session.close();
    }
}
