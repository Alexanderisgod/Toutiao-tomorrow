package com.neu.service.impl;

import com.neu.dao.ReviewDao;
import com.neu.model.Review;
import com.neu.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;


    @Override
    public List<Review> getMovieComments(long movieId) {
        return null;
    }

    @Override
    public List<Review> showCommentByTimeOrStar(long movieId, String order) {
        return null;
    }

    @Override
    public List<Review> moreComment(long movieId, int page) {
        return null;
    }

    @Override
    public int addStarToComment(long userId, long commentId, long userToCommentId) {
        return 0;
    }
}
