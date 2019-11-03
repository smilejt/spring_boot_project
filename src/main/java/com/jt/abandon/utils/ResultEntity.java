package com.jt.abandon.utils;

import java.io.Serializable;

/**
 * @Author: LY
 * @Description: 返回封装实体
 * @Date: 2019/11/3 19:13
 */
public class ResultEntity<T> implements Serializable {

    private static final long serialVersionUID = 4445804658433014617L;
    /**
     * 结果标识
     */
    private boolean flag;

    /**
     * 结果码
     */
    private Integer code;

    /**
     * 消息
     */
    private String message;

    /**
     * 数据对象
     */
    private T data;
    private Long count;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public ResultEntity() {
    }

    private ResultEntity(boolean flag, Integer code, String message) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
    }

    private ResultEntity(boolean flag, Integer code, String message, T data) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    private ResultEntity(boolean flag, Integer code, String message, T data, Long count) {
        super();
        this.flag = flag;
        this.code = code;
        this.message = message;
        this.data = data;
        this.count = count;
    }

    /**
     * 返回成功消息
     * @return Result
     */
    public static ResultEntity ok() {
        return new ResultEntity(true, StatusCode.OK, StatusCode.OK_TEXT);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static ResultEntity error() {
        return new ResultEntity(false, StatusCode.ERROR, StatusCode.ERROR_TEXT);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static ResultEntity error(String message) {
        return new ResultEntity(false, StatusCode.ERROR, message);
    }

    /**
     * 返回失败消息
     * @return Result
     */
    public static ResultEntity error(Integer code, String message) {
        return new ResultEntity(false, code, message);
    }

    /**
     * 返回登录失败的消息：用户名或密码错误
     * @return Result
     */
    public static ResultEntity loginError() {
        return new ResultEntity(false, StatusCode.LOGIN_ERROR, StatusCode.LOGIN_ERROR_TEXT);
    }

    /**
     * 返回权限不足
     * @return Result
     */
    public static ResultEntity accessError() {
        return new ResultEntity(false, StatusCode.ACCESS_ERROR, StatusCode.ACCESS_ERROR_TEXT);
    }

    /**
     * 返回远程调用失败
     * @return Result
     */
    public static ResultEntity remoteError() {
        return new ResultEntity(false, StatusCode.REMOTE_ERROR, StatusCode.REMOTE_ERROR_TEXT);
    }

    /**
     * 返回重复操作
     * @return Result
     */
    public static ResultEntity repError() {
        return new ResultEntity(false, StatusCode.REP_ERROR, StatusCode.REP_ERROR_TEXT);
    }
}
