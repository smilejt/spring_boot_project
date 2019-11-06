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
    public static final int OK = 20200;
    public static final String OK_TEXT = "成功";
    public static final String LOGIN_OK_TEXT = "登录成功";

    /**
     * 失败
     */
    public static final int ERROR = 20201;
    public static final String ERROR_TEXT = "失败";

    /**
     * 用户名或密码错误
     */
    public static final int LOGIN_ERROR = 20402;
    public static final String LOGIN_ERROR_TEXT = "登录失败";
    public static final String USERNAME_OR_PASSWORD_ERROR_TEXT = "用户名或密码错误";
    public static final String USER_DISABLED_ERROR_TEXT = "用户被禁用";

    /**
     * 权限不足
     */
    public static final int ACCESS_ERROR = 20403;
    public static final String ACCESS_ERROR_TEXT = "权限不足";

    /**
     * 远程调用失败
     */
    public static final int REMOTE_ERROR = 20404;
    public static final String REMOTE_ERROR_TEXT = "远程调用失败";

    /**
     * 重复操作
     */
    public static final int REP_ERROR = 20405;
    public static final String REP_ERROR_TEXT = "重复操作";

    /**
     * 未登录
     */
    public static final int UN_LOGIN = 20406;
    public static final String UN_LOGIN_TEXT = "未登录,请登录后再试";
}
