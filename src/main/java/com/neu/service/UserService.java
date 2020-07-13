package com.neu.service;

import com.neu.model.User;
import com.neu.model.UserHasWatched;

import java.math.BigInteger;
import java.util.List;
import java.util.Map;

public interface UserService {

   int login(String username, String password);//登录

   int register(User user, String password);        //注册

   /*
      条件：前端判断是否登录，需要获取id号码
    */
   int cancelById(BigInteger id);         //注销

   void uploadImage();

   long getUserId(User user);

   User getUserInfo(long userID);

   List<Object> goHome(long id);

   List<Object> getUserMovie(User user);

   Map<Object,Object> getUserMType(User user);

   Map<Object,Object> getUserMTime(User user);

   Map<Object,Object> getUserMLocation(User user);

   Map<Object,Object> getUserTime(User user);
}
