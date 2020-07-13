package com.neu.service;

import com.neu.model.Review;

import java.util.List;

public interface ReviewService {
    List<Review> getMovieComments(long movieId);            //获取comment
    List<Review> showCommentByTimeOrStar(long movieId, String order);           //按时间排序
    List<Review> moreComment(long movieId, int page);                 //更多comment
    int addStarToComment(long userId, long commentId, long userToCommentId);//comment点赞
}
