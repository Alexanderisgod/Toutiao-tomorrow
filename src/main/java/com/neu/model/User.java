package com.neu.model;

//import org.springframework.stereotype.Component;

import java.sql.Date;

//@Component
public class User {
    private long uId;
    private String uName;
    private String gender; //用户性别
    private int age;
    private String introduction;
    private Date birth; //生日
    private String local; //地区

    public User(){super();}

    public User(long uId,String uName,String gender,int age,String introduction,Date birth,String local){
        this.uId=uId;
        this.uName=uName;
        this.gender=gender;
        this.age=age;
        this.introduction=introduction;
        this.birth=birth;
        this.local=local;
    }

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String toString() {
        return uId+" "+uName+" "+gender+" "+age+" "+introduction+" "+birth+" "+local;
    }
}
