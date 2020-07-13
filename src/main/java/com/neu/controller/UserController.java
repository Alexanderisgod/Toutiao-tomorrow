package com.neu.controller;

import com.neu.service.impl.UserServiceImpl;
import com.neu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping("/login")
    public int login(
            @RequestParam(value="username", required = false) String username,
            @RequestParam(value="password", required = false) String password
    ){
        /*
        0: 代表内部数据格式错误
        1: 代表用户注册成功
        2: 代表用户名存在
         */
        System.out.println(username+" "+password);
        return userServiceImpl.login(username, password);
    }

    @RequestMapping("/register")
    public int register(String uName, String password){
        /*
        0: 代表内部数据格式错误
        1: 代表用户注册成功
        2: 代表用户名存在
         */
        if(uName==null)
            return 0;
        User user=new User();
        user.setuName(uName);
        return userServiceImpl.register(user,password);
    }


    @RequestMapping("/cancel")
    public int cancel(BigInteger id){
        /*
        数据验证
        0：内部错误
        1：返回结果：注销成功
         */
        return userServiceImpl.cancelById(id);
    }

    @RequestMapping("/home")
    public Object goHome(BigInteger id){
        return userServiceImpl.goHome(id);
    }

    @RequestMapping("person/{userId}")
    public void test(@PathVariable("userId") Integer id){
        User user = userServiceImpl.getUserInfo(id);
        Map location = userServiceImpl.getUserMLocation(user);
        Map type = userServiceImpl.getUserMType(user);
        Map time = userServiceImpl.getUserMTime(user);
        Map Utime = userServiceImpl.getUserTime(user);

    }


}
