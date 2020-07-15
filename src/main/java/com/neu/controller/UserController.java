package com.neu.controller;

import com.neu.service.impl.UserServiceImpl;
import com.neu.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;
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

    /*需要前端获取userID*/

    @RequestMapping("person/{userId}")
    public void showPersonPage(
//            private long uId;
//            private String uName;
//            private String gender; //用户性别
//            private int age;
//            private String introduction;
//            private Date birth; //生日
//            private String local; //地区
            @PathVariable("userId") Integer id,
            @RequestParam(value="username", required = false) String username,
            @RequestParam(value="gender", required = false) String gender,
            @RequestParam(value = "age",required = false) int age,
            @RequestParam(value = "introduction",required = false) String introduction,
            @RequestParam(value = "birth",required = false) Date birth,
            @RequestParam(value = "local",required = false) String local
    ){
        User user = userServiceImpl.getUserInfo(id);
        List<Object> userwatched = userServiceImpl.getUserWatchedMovie(user);
        List<Object> userwantwatch = userServiceImpl.getUserWantWatched(user);
        Map location = userServiceImpl.getUserMLocation(user);
        Map type = userServiceImpl.getUserMType(user);
        Map time = userServiceImpl.getUserMTime(user);
        Map Utime = userServiceImpl.getUserTime(user);

    }
    @RequestMapping("info/{userId}")
    public void changeInfo(
            @PathVariable("userId") long id,
            @RequestParam(value="username", required = false) String username,
            @RequestParam(value="gender", required = false) String gender,
            @RequestParam(value = "age",required = false) int age,
            @RequestParam(value = "introduction",required = false) String introduction,
            @RequestParam(value = "birth",required = false) Date birth,
            @RequestParam(value = "local",required = false) String local
    ){

        User user = new User();
        user.setuId(id);
        user.setuName(username);
        user.setGender(gender);
        user.setBirth(birth);
        user.setAge(age);
        user.setIntroduction(introduction);
        user.setLocal(local);
//        if(){
//
//            return userServiceImpl.changeUserInfo(user);
//        }
    }


}
