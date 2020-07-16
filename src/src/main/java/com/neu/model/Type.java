/*
不同电影类型的统计表
 */

package com.neu.model;

public class Type {
    private String mType; //电影类型
    private long mId; //电影id

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }

    public long getmId() {
        return mId;
    }

    public void setmId(long mId) {
        this.mId = mId;
    }
}
