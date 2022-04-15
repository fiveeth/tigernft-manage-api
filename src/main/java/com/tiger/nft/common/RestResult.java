package com.tiger.nft.common;

import java.util.Date;

/**
 * @author xxx
 */
public class RestResult<T> {
    //系统异常
    public static final int SYS_ERROR = -1;
    //成功
    public static final int SUCCESS = 0;
    //业务校验错误
    public static final int BIZ_ERROR = 20001;
    //参数校验错误
    public static final int PARAM_ERROR = 20002;
    //Token无效
    public static final int TOKEN_INVALID = 20003;
    //无权限
    public static final int PERMISSION_DENY = 20004;

    private long code = SUCCESS;
    private String msg = "success";
    private Date date = new Date();
    private T data;

    private RestResult(T data, int code, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public static <T> RestResult<T> deny(String message) {
        return new RestResult<>(null, PERMISSION_DENY, message);
    }

    public static <T> RestResult<T> error(String message) {
        return new RestResult<>(null, BIZ_ERROR, message);
    }

    public static <T> RestResult<T> success(T data) {
        return new RestResult<>(data, SUCCESS, "");
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
