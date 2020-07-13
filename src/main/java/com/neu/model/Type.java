/*
不同电影类型的统计表
 */

package com.neu.model;

import java.math.BigInteger;

public class Type {
    private String mType; //电影类型
    private BigInteger mId; //电影id

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public BigInteger getmId() {
        return mId;
    }

    public void setmId(BigInteger mId) {
        this.mId = mId;
    }
}
