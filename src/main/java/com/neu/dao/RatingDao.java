package com.neu.dao;

import com.neu.model.Rating;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

@Mapper
public interface RatingDao {
    //插入一条评分
    @Update("insert into rating(uId, mId, rate) values (#{rId},#{uId},#{mId},#{rate})")
    int addRating(Rating r);
    //修改评分，任何参数
    @Update("update rating set rate=#{rate} where rId=#{rId}")
    int updateRatingById(Rating r);
    //根据评分/用户/电影id，获得评分
    List<Rating> getRatingIF(Map map);
    //根据评分id，删除一条评分
    @Delete("delete from rating where rId=#{rId}")
    int deleteRatingById(long rId);

}
