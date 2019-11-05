package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @createData: 2019-11-05 11:37
 * @author: LongJunTao
 * @Description: 登录失败
 */
@Component
public class MyAuthenticationFailHandler implements AuthenticationFailureHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationFailHandler.class);

    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("[MyAuthenticationFailHandler].[onAuthenticationFailure]----------> 执行登录失败");
        ResultEntity<String> authenticationResultEntity = new ResultEntity<>();
        authenticationResultEntity.setFlag(false);
        authenticationResultEntity.setCode(StatusCode.LOGIN_ERROR);
        authenticationResultEntity.setMessage(StatusCode.LOGIN_ERROR_TEXT);
        authenticationResultEntity.setData(e.getMessage());
        httpServletResponse.setContentType(CONTENT_TYPE);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(authenticationResultEntity));
        out.flush();
        out.close();
    }
}
