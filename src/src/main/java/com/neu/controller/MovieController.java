package com.neu.controller;

import com.neu.model.Movie;
import com.neu.model.Review;
import com.neu.service.impl.MovieServiceImpl;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {
    @Autowired
    private MovieServiceImpl movieServiceImpl;

    @RequestMapping("/popular")
    public ResultUtil<Movie> getPopularMovies(){
        return movieServiceImpl.getPopularMovies();
    }

    @RequestMapping("/query")
    public ResultUtil<Movie> getMovieInfo(long m_id){
        return movieServiceImpl.getMovieById(m_id);
    }

    //按page, 获取影评
    @RequestMapping("/reviews")
    public ResultUtil<Review> getMovieReviews(long m_id, int page){
        if (!(page>0))
            return ReturnResultUtil.returnFail(400,"页数不正确");
        return movieServiceImpl.getMovieReviewsByPage(m_id, page);
    }

    //写影评
    @RequestMapping("/write_review")
    public ResultUtil<Review> writeMovieReview(long m_id, long u_id, int r_star, String comment, int tag){
        movieServiceImpl.updateMovieTag(m_id, u_id, tag);
        return movieServiceImpl.editReviewForMovie(m_id, u_id,r_star, comment);
    }

    @RequestMapping("/updateTag")
    public ResultUtil updateTag(long u_id, long m_id, int tag){
        return movieServiceImpl.updateMovieTag(m_id, u_id, tag);
    }

    @RequestMapping("/sort")
    public ResultUtil<Movie> getMovieBySort(String integrated, String area, String type, String year, int page){
        return movieServiceImpl.getMovieBySort(integrated, area, type, year, page);
    }
}
