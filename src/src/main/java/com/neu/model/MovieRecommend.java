/*
根据电影推荐电影的表
 */

package com.neu.model;


public class MovieRecommend {
    private long uId; //推荐的电影
    private long movieId; //电影id

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
