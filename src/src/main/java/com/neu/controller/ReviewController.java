package com.neu.controller;

import com.neu.service.impl.ReviewServiceImpl;
import com.neu.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    private ReviewServiceImpl reviewServiceImpl;

    @RequestMapping("/like")
    public ResultUtil<Integer> addLike(long r_id){
        return reviewServiceImpl.addStarToComment(r_id);
    }

}
