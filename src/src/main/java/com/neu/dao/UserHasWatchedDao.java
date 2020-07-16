package com.neu.dao;


import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Mapper
@Component
public interface UserHasWatchedDao {
    @Select("select count(*) from user_has_watched where m_id=#{mId} and u_id=#{uId}")
    int userHasWatched(long mId, long uId);

    @Delete("delete from user_has_watched where m_id=#{mId} and u_id=#{uId}")
    int hasNotWatched(long mId, long uId);

    @Insert("insert into user_has_watched values(#{uId}, #{mId}, #{time})")
    int hasWatched(long mId, long uId, Timestamp time);
}
