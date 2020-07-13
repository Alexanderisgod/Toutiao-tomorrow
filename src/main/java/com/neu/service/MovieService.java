package com.neu.service;

import com.neu.model.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(long movieId);                 //获取movie信息
    List<Movie> showMovieByType(String type, int page);//电影类型， page
    List<Movie> searchMovie(String moveString);         //搜索电影
}
