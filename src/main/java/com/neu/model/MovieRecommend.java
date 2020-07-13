/*
根据电影推荐电影的表
 */

package com.neu.model;

public class MovieRecommend {
    private long mId; //推荐的电影
    private long movieId; //电影id

    public MovieRecommend(){super();}

    public MovieRecommend(long mId,long movieId){
        this.mId=mId;
        this.movieId=movieId;
    }

    public long getuId() {
        return mId;
    }

    public void setuId(long uId) {
        this.mId = uId;
    }

    public long getMovieId() {
        return movieId;
    }

    public void setMovieId(long movieId) {
        this.movieId = movieId;
    }
}
