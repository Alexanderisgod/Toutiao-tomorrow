package com.neu.service.impl;

import com.neu.dao.MovieDao;
import com.neu.dao.PasswordDao;
import com.neu.model.Movie;
import com.neu.model.User;
import com.neu.dao.UserDao;
import com.neu.service.RecommendService;
import com.neu.service.UserService;
import com.neu.utils.ResultUtil;
import com.neu.utils.ReturnResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordDao passwordDao;
    @Autowired
    private MovieDao movieDao;

    @Override
    public ResultUtil<User> login(String username, String password) {
        //寻找是否有此用户
        User user = userDao.selectUserByName(username);
        if (user == null) {
            return ReturnResultUtil.returnFail(420,"不存在此用户！");
        }
        String correctPassword = passwordDao.getPasswordById(user.getuId());
        if (correctPassword.equals(password))
            return ReturnResultUtil.returnSuccess();
        return ReturnResultUtil.returnFail(420, "密码错误！");
    }

    @Override
    public ResultUtil<User> findback(String uName, String password, String email) {
        //判断u_id, email是否一致
        User user=userDao.selectUserByName(uName);
        if (user==null)
            return ReturnResultUtil.returnFail(420, "没有此用户！");
        if(user.getEmail().equals(email)){
            //修改密码
            long id=user.getuId();
            passwordDao.modifyPassword(id, password);
            return ReturnResultUtil.returnSuccess(user);
        }
        else
            return ReturnResultUtil.returnFail(421, "邮箱错误！");
   }

    @Override
    public int register(User user, String password) {
        if (userDao.selectUserByName(user.getuName()) != null)
            return 2;
        userDao.insert(user);
        passwordDao.register((userDao.selectUserByName(user.getuName())).getuId(), password);
        return 1;
    }

    @Override
    public int cancelById(long id) {
        return userDao.deleteById(id);
    }

    @Override
    public void uploadImage() {

    }

    @Override
    public List<Object> goHome(long id) {
        //获取通过用户id获取用户个人信息，同时获取当下流行电影
        List<Object> res = new ArrayList<>();
        User user = userDao.selectById(id);
        res.add(user);
//            User user1=(User)res.get("user");
//            System.out.println(user1.toString());
        List<Movie> popularMovies = movieDao.getPopularMovies(2);

        res.add(popularMovies);
//            List<Movie> movies1=(List<Movie>)res.get("popularMovies");
//            for(Movie m:movies1){
//                System.out.println(m.toString());
//            }
        return res;

    }

}
