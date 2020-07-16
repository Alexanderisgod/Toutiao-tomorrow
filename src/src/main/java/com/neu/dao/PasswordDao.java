package com.neu.dao;

import com.neu.model.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface PasswordDao {
    @Select("insert into password values(#{u_id},#{password})")
    void register(long u_id, String password);

    @Select("select password from password where u_id=#{u_id}")
    String getPasswordById(long u_id);

    @Update("update password set password=#{password} where u_id=#{id}")
    int modifyPassword(long id, String password);
}
