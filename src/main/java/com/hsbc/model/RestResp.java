package com.hsbc.model;

import java.util.Date;

/**
 *
 * @author Xieboyun
 */
public class RestResp implements java.io.Serializable {


    public static final Integer OK = 200;
    public static final Integer ERROR = 500;

    // 默认成功
    private Integer code = OK;

    private String msg;

    private Object data;
    private String path;
    private Date timestamp;


    private RestResp() {

    }

    private RestResp(Object data) {
        this.data = data;
    }

    private RestResp(Integer code, String msg, String path) {
        this.code = code;
        this.msg = msg;
        this.path = path;
        this.timestamp = new Date();
    }

    private RestResp(Integer code, String msg) {
        this(code, msg, null);
    }


    public static RestResp ok(String msg) {
        return new RestResp(OK, msg);
    }

    public static RestResp error(Integer code, String msg) {
        return new RestResp(code, msg);
    }

    public static RestResp error(Integer code, String msg, String path) {
        return new RestResp(code, msg, path);
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
