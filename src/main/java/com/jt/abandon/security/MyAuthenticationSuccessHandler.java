package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @createData: 2019-11-05 11:39
 * @author: LongJunTao
 * @Description: 登录成功
 */
@Component
public class MyAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyAuthenticationSuccessHandler.class);

    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("[MyAuthenticationSuccessHandler].[onAuthenticationSuccess]----------> 执行登录成功");
        ResultEntity<Authentication> authenticationResultEntity = new ResultEntity<>();
        authenticationResultEntity.setFlag(true);
        authenticationResultEntity.setCode(StatusCode.OK);
        authenticationResultEntity.setMessage(StatusCode.LOGIN_OK_TEXT);
        authenticationResultEntity.setData(authentication);
        httpServletResponse.setContentType(CONTENT_TYPE);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(authenticationResultEntity));
        out.flush();
        out.close();
    }
}
