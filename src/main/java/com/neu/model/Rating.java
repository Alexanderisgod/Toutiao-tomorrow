/*
用户对电影的评分
 */

package com.neu.model;

public class Rating {
    private long rId; //评分id
    private long uId; //用户id
    private long mId; //电影id
    private float rate; //电影评分

    public Rating(){super();}

    public Rating(long rId,long uId,long mId,float rate){
        this.rId=rId;
        this.uId=uId;
        this.mId=mId;
        this.rate=rate;
    }

    public long getrId() {
        return rId;
    }

    public void setrId(long rId) {
        this.rId = rId;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }
}
