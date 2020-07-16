package com.neu.dao;

import com.neu.model.Review;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface ReviewDao {
    @Insert("Insert into review(r_id,u_id, m_id, r_time, commend, r_star, agree_num)" +
            " values (" +1+','+
            "#{uId}, #{mId}," +
            "#{rTime}, #{comment}, " +
            "#{rStar}, #{agreeNum})")
    int editReviewForMovie(Review review);

    @Select("select count(*) from review where m_id=#{mId}")
    int getReviewCount(long mId);

    @Select("select agree_num from review where r_id=#{r_id}")
    int getReviewAgree(long r_id);

    @Select("select * from review where m_id=#{mId} order by #{order} desc limit #{start}, #{count}")
    List<Review> getMovieReviewsByPage(long mId, int start, int count, String order);

    @Update("update review set agree_num=agree_num+1 where r_id=#{r_id}")
    int addStar(long r_id);
}
