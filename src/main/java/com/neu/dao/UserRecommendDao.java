package com.neu.dao;

import com.neu.model.Movie;
import com.neu.model.UserRecommend;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRecommendDao {
    //增
    @Insert("insert into user_recommend(uId, movieId) values (#{uId},#{movieId})")
    int addUserRecommend(UserRecommend u);
    //删,根据用户/电影/用户电影id
    int deleteUserRecommendIF(Map map);
    //改,修改用户 电影id
    @Update("update user_recommend set movieId=#{movieId},where uId=#{uId} and movieId=#{movieId1}")
    int updateUserRecommend(UserRecommend u);
    //查,根据用户id,获得电影信息
    List<Movie> getMovieByUserId(long uId);
}
