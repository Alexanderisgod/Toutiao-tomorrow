package com.neu.dao;

import com.neu.model.Review;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ReviewDao {
    //插入一条评论
    @Insert("insert into review(uId, mId, rTime, commend, rStar, agreeNum) values (#{rId},#{uId},#{mId},#{rTime},#{commend},#{rStar},#{agreeNum})")
    int addReview(Review r);
    //修改评论，任何参数
    int updateReviewById(Map map);
    //根据评论/用户/电影id，获得评论
    List<Review> getReviewIF(Map map);
    //根据热度/时间/评分获得排序评论
    List<Review> getReviewSort(Map map);
    //根据评论id，删除一条评论
    @Delete("delete from review where rId=#{rId}")
    int deleteReviewById(long rId);
}
