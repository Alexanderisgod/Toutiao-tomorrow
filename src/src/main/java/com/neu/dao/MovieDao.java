package com.neu.dao;

import com.neu.model.Movie;
import com.neu.utils.ResultUtil;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface MovieDao {
    @Insert("")
    void insert(Movie movie);

    @Delete("")
    void delete(long id);

    @Update("")
    void update(long id);

    @Select("select * from movie where m_id=#{id}")
    Movie selectById(long id);

    @Select("select * from movie limit 3000, #{num}")
    List<Movie> getPopularMovies(int num);

    //直接选取
    @Select("select movie.* from movie, type where #{condition} order by #{order} desc, PK limit #{start}, #{count} ")
    List<Movie> getMoiveBySort(String condition, String order, int start, int count);
}
