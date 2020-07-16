package com.neu.service.impl;

import com.neu.dao.MovieDao;
import com.neu.dao.MovieRecommendDao;
import com.neu.dao.ReviewDao;
import com.neu.dao.UserHasWatchedDao;
import com.neu.model.Movie;
import com.neu.model.Review;
import com.neu.service.MovieService;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import scala.Int;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    UserHasWatchedDao userHasWatchedDao;
    @Autowired
    ReviewDao reviewDao;
    @Autowired
    MovieRecommendDao movieRecommendDao;
    @Autowired
    MovieDao movieDao;
    @Value("${movies_per_page}")
    private int movies_per_page;
    private String order="r_time";//排序方式， r_time： 时间顺序， r_star：点赞数量排序

    @Override
    public ResultUtil<Movie> getMovieById(long movieId) {
        Movie movie=new Movie();
        try {
            movie=movieDao.selectById(movieId);
        }catch (Exception e) {
            return ReturnResultUtil.returnFail(400, e.toString());
        }
        if(movie==null)
            return ReturnResultUtil.returnFail(401, "无此电影");
        return ReturnResultUtil.returnSuccess(movie);
    }

    @Override
    public List<Movie> searchMovie(String moveString) {
        return null;
    }

    @Override
    public List<Object> getMovieMainPage(long uId, long mId) {
        List<Object> list=new ArrayList<Object>();
        list.add(userHasWatchedDao.userHasWatched(mId, uId));
        list.add(getMovieReviewsByPage(mId, 0));
        list.add(movieRecommendDao.getMovieRecommendMovies(mId));
        return list;
    }

    @Override
    public ResultUtil<Movie> getPopularMovies() {
        return ReturnResultUtil.returnSuccess(movieDao.getPopularMovies(10));
    }

    @Override
    public ResultUtil updateMovieTag(long mId, long uId, int tag) {
        //修改是否  看过: 2, 想看: 1，没看: 0
        if(tag==0){
            int hasWatched=userHasWatchedDao.userHasWatched(mId, uId);
            if(hasWatched==1)
                userHasWatchedDao.hasNotWatched(mId, uId);
            return ReturnResultUtil.returnSuccess();
        }
        else if (tag==2) {
            userHasWatchedDao.hasWatched(mId, uId, (new Timestamp(System.currentTimeMillis())));
            return ReturnResultUtil.returnSuccess();
        }
        else
            return ReturnResultUtil.returnFail(402, "未完成相应的数据功能");
    }

    @Override
    public ResultUtil<Review> getMovieReviewsByPage(long mId, int page) {
        //获取总体的评论数量
        int reviewNum=reviewDao.getReviewCount(mId);
        int maxIndex=movies_per_page*page;
        int count=movies_per_page;
        int startIndex=movies_per_page*(page-1);
        if(startIndex>reviewNum)
            return ReturnResultUtil.returnFail(400, String.format("pageNum:%d", (reviewNum/movies_per_page)));
        if(reviewNum<maxIndex){
            count=reviewNum-startIndex;
        }
        return ReturnResultUtil.returnSuccess(reviewDao.getMovieReviewsByPage (mId,
                startIndex,count, order));
    }

    @Override
    public ResultUtil<Review> editReviewForMovie(long mId, long uId, int r_star, String comment) {
        Review review=new Review();
        review.setmId(mId);
        review.setuId(uId);
        review.setrStar(r_star);
        review.setrTime(new Timestamp(System.currentTimeMillis()));
        review.setComment(comment);
        review.setrStar(0);
        review.setAgreeNum(0);
        try {
            reviewDao.editReviewForMovie(review);
        }catch (Exception e){
            return ReturnResultUtil.returnFail(400, "请先打分");
        }

        return ReturnResultUtil.returnSuccess();
    }

    @Override
    public ResultUtil<Movie> getMovieBySort(String integrated, String area, String type, String year, int page) {
        String condition="";
        String order=integrated;
        int conditionNum=0;
        if (area!="") {
            condition += "area like'%" + area + "%' ";
            conditionNum++;
        }
        if(type!=""){
            if (conditionNum!=0){
                condition+="and ";
            }
            condition+="type="+type+" ";
            conditionNum++;
        }
        if(year!=""){
            if(conditionNum!=0){
                condition+="and ";
            }
            //比对时间
            //select * from movie where
            //              convert(substring(start_time, 1, 4), signed)=2019 limit 10;
            //2020年, 2019年，2018年，2017年，
            //2016-2011年，2010-2000年
            // 90年代，80年代，更早
            String startTime="convert(substring(start_time, 1, 4), signed)";
            String terms="";
            if(year.equals("2020") ||  year.equals("2019") ||year.equals("2018") ||  year.equals("2017")){
                terms=String.format("%s = %d", startTime, Integer.parseInt(year));
            }
            else if(year.equals("2016-2011年")){
                terms=String.format(" %s <=2016 and %s >= 2011 ", startTime, startTime);
            }
            else if(year.equals("2010-2000年")){
                terms=String.format(" %s <=2010 and %s >= 2000 ", startTime, startTime);
            }
            else if(year.equals("90年代")){
                terms=String.format(" %s <=1999 and %s >= 1990 ", startTime, startTime);
            }
            else if(year.equals("80年代")){
                terms=String.format(" %s <=1989 and %s >= 1980 ", startTime, startTime);
            }
            else
                terms=String.format(" %s<= 1980 ", startTime);
            condition+=terms+" ";
        }
        List<Movie> movies=movieDao.getMoiveBySort(condition, order, movies_per_page*(page-1),movies_per_page+1);
        //每次多读一个电影，查看是否还有剩余
        if (movies.size()<=movies_per_page) {
            return ReturnResultUtil.returnFail(405, movies);//没有下一页了
        }
        else
            return ReturnResultUtil.returnSuccess(movies.subList(0, movies_per_page - 1));
    }
}
