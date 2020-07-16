package com.neu.model;

import java.sql.Timestamp;

/*
用户对其他用户评论的点赞和查看
 */
public class Review {
    private long rId;
    private long uId;
    private long mId;
    private Timestamp rTime;
    private String comment;
    private int rStar; // 评星等级
    private int agreeNum; //点赞次数

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

    public Timestamp getrTime() {
        return rTime;
    }

    public void setrTime(Timestamp rTime) {
        this.rTime = rTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getrStar() {
        return rStar;
    }

    public void setrStar(int rStar) {
        this.rStar = rStar;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }
}
