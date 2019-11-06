package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @createData: 2019-11-06 11:02
 * @author: LongJunTao
 * @Description: 未登录返回
 */
@Component
public class MyAuthenticationEntryPoint implements AuthenticationEntryPoint {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationEntryPoint.class);

    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
        logger.info("[MyAuthenticationEntryPoint].[commence]----------> 执行未登录拦截返回");
        ResultEntity<String> authenticationResultEntity = new ResultEntity<>();
        authenticationResultEntity.setFlag(false);
        authenticationResultEntity.setCode(StatusCode.UN_LOGIN);
        authenticationResultEntity.setMessage(StatusCode.UN_LOGIN_TEXT);
        httpServletResponse.setContentType(CONTENT_TYPE);
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(authenticationResultEntity));
        out.flush();
        out.close();
    }
}
