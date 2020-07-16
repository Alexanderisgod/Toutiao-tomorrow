package com.neu.service;

import com.neu.model.Movie;

import java.util.List;

public interface RecommendService {
    List<Movie> userRecommendMovies(long userId, int num);          //为用户推荐电影
    List<Movie> movieRecommendMovies(long movieId, int num);        //推荐相似movie
}
