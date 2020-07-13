package com.neu.model;

import java.math.BigInteger;

public class UserWantWatch {
    private BigInteger uId;
    private BigInteger mId;

    public BigInteger getuId() {
        return uId;
    }

    public void setuId(BigInteger uId) {
        this.uId = uId;
    }

    public BigInteger getmId() {
        return mId;
    }

    public void setmId(BigInteger mId) {
        this.mId = mId;
    }
}
