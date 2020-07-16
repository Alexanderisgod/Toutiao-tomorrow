package com.neu.model;

import org.springframework.stereotype.Component;


@Component
public class Password {
    private long uId;//用户id
    private String password;//用户密码

    public long getuId() {
        return uId;
    }

    public void setuId(long uId) {
        this.uId = uId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
