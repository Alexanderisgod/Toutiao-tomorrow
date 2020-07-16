package com.neu.service.impl;

import com.neu.dao.ReviewDao;
import com.neu.model.Review;
import com.neu.service.ReviewService;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewServiceImpl implements ReviewService {
    @Autowired
    private ReviewDao reviewDao;


    @Override
    public ResultUtil<Review> getMovieComments(long movieId) {
        return null;
    }

    @Override
    public List<Review> showCommentByTimeOrStar(long movieId, String order) {
        return null;
    }

    @Override
    public ResultUtil<Review> moreComment(long movieId, int page) {
        return null;
    }

    @Override
    public int addStarToComment(long userId, long commentId, long userToCommentId) {
        return 0;
    }

    @Override
    public ResultUtil<Integer> addStarToComment(long r_id) {
        int num=reviewDao.addStar(r_id);
        if(num==0)
            return ReturnResultUtil.returnFail(500, "评论不存在");
        int agree_num=reviewDao.getReviewAgree(r_id);
        return ReturnResultUtil.returnSuccess(agree_num);
    }
}
