package com.neu.utils;

public class ReturnResultUtil {
    public static ResultUtil returnSuccess(){
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(200);
        resultUtil.setMsg("success");
        return resultUtil;
    }
    public static ResultUtil returnSuccess(Object data){
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(200);
        resultUtil.setMsg("success");
        resultUtil.setData(data);
        return resultUtil;
    }
    public static ResultUtil returnFail(Integer code,  Object data){
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(code);
        resultUtil.setData(data);
        return resultUtil;
    }
    public static ResultUtil returnFail(Integer code, String msg){
        ResultUtil resultUtil=new ResultUtil();
        resultUtil.setCode(code);
        resultUtil.setMsg(msg);
        return resultUtil;
    }
}
