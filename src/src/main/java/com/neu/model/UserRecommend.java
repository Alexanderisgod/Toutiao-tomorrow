/*
根据用户推荐电影的表
 */

package com.neu.model;


public class UserRecommend {
    private long uId; //用户id
    private long movieId; //为用户推荐的电影id

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
