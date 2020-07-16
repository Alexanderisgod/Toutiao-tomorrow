package com.neu.controller;

import com.neu.service.impl.UserServiceImpl;
import com.neu.model.User;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultUtil<User> login(String username, String password){
        return userServiceImpl.login(username, password);
    }

    @RequestMapping(value = "/findback", method = RequestMethod.POST)
    public ResultUtil<User> findback(String uName, String password,String email){
        System.out.println("password: "+password);
        return userServiceImpl.findback(uName, password, email);
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


    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public int cancel(long id){
        /*
        数据验证
        0：内部错误
        1：返回结果：注销成功
         */
        System.out.println("删除用户");
        return userServiceImpl.cancelById(id);
    }

    @RequestMapping("/home")
    public Object goHome(long id){
        return userServiceImpl.goHome(id);
    }
}
