package com.neu.dao;

import com.neu.model.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

//import org.springframework.stereotype.Component;

@Mapper
//@Component
public interface UserDao {

    //插入一项用户信息
    @Insert("insert into user(uId, uName, gender, age, introduction, birth, local) values (#{uId},#{uName},#{gender},#{age},#{introduction},#{birth},#{local})")
    int addUser(User user);
    //根据用户id获得用户全部信息
    @Select("select * from user where uId=#{uId}")
    User getUserById(long uId);
    //根据用户id删除一项用户信息
    @Delete("delete from user where uId=#{uId}")
    int deleteUserById(long uId);
    //修改用户信息，任何参数
    int updateUserById(Map map);

}
