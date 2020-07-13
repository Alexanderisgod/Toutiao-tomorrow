package com.neu.dao;

import com.neu.model.Movie;

import java.util.List;

/**
 * @author ysy
 * @create 2020/7/11-16:21
 */
public interface UserHasWatchedDao {
    //根据用户id获得用户看过电影信息
    List<Movie> getMovieByUserId(long uId);
    //增
    //删
    //改
}
