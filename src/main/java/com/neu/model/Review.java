package com.neu.model;

import java.sql.Date;

/*
用户对其他用户评论的点赞和查看
 */
public class Review {
    private long rId;
    private long uId;
    private long mId;
    private Date rTime;
    private String commend;
    private float rStar; // 评星等级
    private int agreeNum; //点赞次数

    public Review(){super();}

    public Review(long rId,long uId,long mId,Date rTime,String commend,float rStar,int agreeNum){
        this.rId=rId;
        this.uId=uId;
        this.mId=mId;
        this.rTime=rTime;
        this.commend=commend;
        this.rStar=rStar;
        this.agreeNum=agreeNum;
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

    public Date getrTime() {
        return rTime;
    }

    public void setrTime(Date rTime) {
        this.rTime = rTime;
    }

    public String getCommend() {
        return commend;
    }

    public void setCommend(String commend) {
        this.commend = commend;
    }

    public float getrStar() {
        return rStar;
    }

    public void setrStar(float rStar) {
        this.rStar = rStar;
    }

    public int getAgreeNum() {
        return agreeNum;
    }

    public void setAgreeNum(int agreeNum) {
        this.agreeNum = agreeNum;
    }

    public String toString() {
        return rId+" "+uId+" "+mId+" "+rTime+" "+commend+" "+rStar+" "+agreeNum;
    }
}
