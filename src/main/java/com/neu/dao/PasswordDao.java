package com.neu.dao;

import com.neu.model.Password;
import org.apache.ibatis.annotations.*;


public interface PasswordDao {
    //新加入一条数据项
    @Insert("insert into password(uId, password) values (#{uId},#{password})")
    int addPwd(Password pwd);
    //删除一条数据项
    @Delete("delete from password where uId=#{uId}")
    int deleteById(long uId);
    //根据用户id获得密码
    @Select("select * from password where uId=#{uId}")
    Password getPwdById(long uId);
    //根据用户id修改密码
    @Update("update password set password=#{password} where uId=#{uId}")
    int updatePwdById(@Param("uId") long uId, @Param("password")String password);
}
