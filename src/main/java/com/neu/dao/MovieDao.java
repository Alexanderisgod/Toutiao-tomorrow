package com.neu.dao;

import com.neu.model.Movie;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface MovieDao {

    //根据类型/地区/名字/演员/导演/编剧/语言/简介模糊查询电影
    List<Movie> getMovieIF(String text);
    //查询热门电影
    @Select("select * from movie order by click desc,mId desc limit #{num}")
    List<Movie> getMovieByClickSort(int num);
    //根据评分排序电影
    @Select("select * from movie order by rate desc,mId desc limit #{num}")
    List<Movie> getMovieByRateSort(int num);
    //根据电影id获得电影
    @Select("select * from movie where mId=#{mId}")
    Movie getMovieById(long mId);
    //增
    @Insert("insert into movie(mId,mName, rate, director,screenwriter,actor,type,area,language,length,coverurl,click,startTime,introduction) " +
            "values (#{mId},#{mName},#{rate},#{director},#{screenwriter},#{actor},#{type},#{area},#{language},#{length},#{coverurl},#{click},#{startTime},#{introduction});")
    int addMovie(Movie m);
    //删
    @Delete("delete from movie where mId=#{mId};")
    int deleteMovieById(long mId);
    //改
    int updateMovieIF(Map map);
}
