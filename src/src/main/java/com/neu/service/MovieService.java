package com.neu.service;

import com.neu.model.Movie;
import com.neu.model.Review;
import com.neu.utils.ResultUtil;

import java.util.List;

public interface MovieService {
    ResultUtil<Movie> getMovieById(long movieId);                 //获取movie信息
    List<Movie> searchMovie(String moveString);         //搜索电影
    List<Object> getMovieMainPage(long uId, long mId);                    //获取电影主页信息
    ResultUtil<Movie> getPopularMovies();                     //获取流行电影
    ResultUtil updateMovieTag(long mId, long uId, int tag);   //修改用户和电影的关系
    ResultUtil<Review> getMovieReviewsByPage(long mId, int page);             //获取第几页评论
    ResultUtil<Review> editReviewForMovie(long mId, long uId, int r_star, String comment);         //编辑评论
    ResultUtil<Movie>  getMovieBySort(String integrated,String area, String type, String year, int page);
}
