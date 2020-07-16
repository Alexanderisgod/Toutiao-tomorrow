package com.neu.service;

import com.neu.model.Review;
import com.neu.utils.ResultUtil;

import java.util.List;

public interface ReviewService {
    ResultUtil<Review> getMovieComments(long movieId);            //获取comment
    List<Review> showCommentByTimeOrStar(long movieId, String order);           //按时间排序
    ResultUtil<Review> moreComment(long movieId, int page);                 //更多comment
    int addStarToComment(long userId, long commentId, long userToCommentId);//comment点赞
    ResultUtil<Integer> addStarToComment(long r_id);//comment点赞
}
