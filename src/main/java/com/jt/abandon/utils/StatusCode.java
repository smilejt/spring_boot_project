package com.jt.abandon.utils;

/**
 * @Author: LY
 * @Description: 状态码
 * @Date: 2019/11/3 19:17
 */
public class StatusCode {

    /**
     * 成功
     */
    public static final int OK = 20000;
    public static final String OK_TEXT = "成功";
    public static final String LOGIN_OK_TEXT = "登录成功";

    /**
     * 失败
     */
    public static final int ERROR = 20001;
    public static final String ERROR_TEXT = "失败";

    /**
     * 用户名或密码错误
     */
    public static final int LOGIN_ERROR = 20002;
    public static final String LOGIN_ERROR_TEXT = "用户名或密码错误";

    /**
     * 权限不足
     */
    public static final int ACCESS_ERROR = 20003;
    public static final String ACCESS_ERROR_TEXT = "权限不足";

    /**
     * 远程调用失败
     */
    public static final int REMOTE_ERROR = 20004;
    public static final String REMOTE_ERROR_TEXT = "远程调用失败";

    /**
     * 重复操作
     */
    public static final int REP_ERROR = 20005;
    public static final String REP_ERROR_TEXT = "重复操作";
}
