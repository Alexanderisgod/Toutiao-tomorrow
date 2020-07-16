package com.neu.dao;

import org.apache.ibatis.annotations.*;
import com.neu.model.User;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    @Insert("insert into user(u_name, gender, age, introduction, birth, local, email) values("+
            "#{uName}, #{gender}, #{age}, " +
            "#{introduction}, #{birth}, " +
            "#{local}, #{email})")
    int insert(User user);

    @Delete("delete from user where u_id=#{id}")
    int deleteById(long id);

    @Select("select * from user where u_id=#{id};")
    User selectById(long id);

    @Select("select * from user where u_name=#{name}")
    User selectUserByName(String name);

}
