package com.neu.model;

import java.sql.Date;

public class Movie {
    private long mId; //电影id
    private String mName; //电影名称
    private float rate; //排名
    private String director; //导演
    private String screenwriter; //编剧
    private String actor; //演员
    private String type; //类别
    private String area; //地区
    private String language; //语言
    private int length; //片长
    private String coverurl; //封面图片url
    private long click; //观看总数
    private Date startTime; //上线时间
    private String introduction; //电影介绍

    public Movie(){super();}

    public Movie(long mId,String mName,float rate,String director,String screenwriter,String actor,String type,String area,String language,int length,String coverurl,long click,Date startTime,String introduction){
        this.mId=mId;
        this.mName=mName;
        this.rate=rate;
        this.director=director;
        this.screenwriter=screenwriter;
        this.actor=actor;
        this.type=type;
        this.area=area;
        this.language=language;
        this.length=length;
        this.coverurl=coverurl;
        this.click=click;
        this.startTime=startTime;
        this.introduction=introduction;

    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getScreenwriter() {
        return screenwriter;
    }

    public void setScreenwriter(String screenwriter) {
        this.screenwriter = screenwriter;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getCoverurl() {
        return coverurl;
    }

    public void setCoverurl(String coverurl) {
        this.coverurl = coverurl;
    }

    public long getClick() {
        return click;
    }

    public void setClick(long click) {
        this.click = click;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String toString(){
        return mId+" "+mName+" "+rate+" "+director+" "+screenwriter
                +" "+actor+" "+type+" "+area+" "+language+" "+length+" "+
                coverurl+" "+click+" "+startTime+" "+introduction;
    }
}
