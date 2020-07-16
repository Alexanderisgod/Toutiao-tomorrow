package com.neu.dao;

import com.neu.model.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface MovieRecommendDao {
    @Select("select * from movie_recommend where m_id=#{mId}")
    List<Movie> getMovieRecommendMovies(long mId);
}
