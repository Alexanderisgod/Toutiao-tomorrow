package com.neu.dao;

import com.neu.model.Movie;
import com.neu.model.MovieRecommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface MovieRecommendDao {
    //增
    @Insert("insert into movie_recommend(mId, movieId) values (#{mId},#{movieId})")
    int addMovieRecommend(MovieRecommend m);
    //删,根据用户/电影/用户电影id
    int deleteMovieRecommendIF(Map map);
    //改
    @Update("update movie_recommend set movieId=#{movieId},where mId=#{mId} and movieId=#{movieId1}")
    int updateMovieRecommend(Map map);
    //查,根据用户id,获得电影信息
    List<Movie> getMovieByMovieId(long mId);
}
