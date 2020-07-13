package com.neu.service.impl;

import com.neu.dao.MovieDao;
import com.neu.dao.PasswordDao;
import com.neu.dao.UserHasWatchedDao;
import com.neu.model.Movie;
import com.neu.model.User;
import com.neu.dao.UserDao;
import com.neu.model.UserHasWatched;
import com.neu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordDao passwordDao;
    @Autowired
    private MovieDao movieDao;

    @Override
    public int login(String username, String password) {
        //寻找是否有此用户
        User user = userDao.selectUserByName(username);
        if (user == null) {
            System.out.println("no such user");
            return 0;
        }
        String correctPassword = passwordDao.getPasswordById(user.getuId());
        if (correctPassword.equals(password))
            return 2;
        return 1;
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
    public int cancelById(BigInteger id) {
        return userDao.deleteById(id);
    }

    @Override
    public void uploadImage() {

    }

    @Override
    public List<Object> goHome(BigInteger id) {
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
    @Override
    public long getUserId(User user){
        return user.getuId();
    }

    @Override
    public User getUserInfo(long userId){

        return userDao.getUserById(userId);
    }

    @Override
    public List<Object> getUserWantWatched(User user) {
        List<Object> res = new ArrayList<>();
        res.addAll(UserHasWatchedDao.getMovieByUserId(user.getuId()));
        return  res;
    }

    @Override
    public List<Object> getUserWatchedMovie(User user){
        List<Object> res = new ArrayList<>();
        res.addAll(UserHasWatchedDao.getMovieByUserId(user.getuId()));
        return  res;
    }




    @Override
    public Map<Object, Object> getUserMType(User user) {

        return userDao.getUserMtype(user);
    }

    @Override
    public Map<Object, Object> getUserMTime(User user) {
        return userDao.getUserMTime(user);
    }

    @Override
    public Map<Object, Object> getUserMLocation(User user) {
        return userDao.getUserMLocation(user);
    }

    @Override
    public Map<Object, Object> getUserTime(User user) {
        return userDao.getUserTime(user);
    }

    @Override
    public User changeUserInfo(long userID) {

    }
}
