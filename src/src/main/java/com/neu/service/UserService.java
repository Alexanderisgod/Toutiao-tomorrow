package com.neu.service;

import com.neu.model.User;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;

import java.util.List;

public interface UserService {

   ResultUtil<User> login(String username, String password);//登录

   int register(User user, String password);        //注册

   ResultUtil<User> findback(String uName, String password, String email); //找回密码

   int cancelById(long id);         //注销

   void uploadImage();

   List<Object> goHome(long id);
}
