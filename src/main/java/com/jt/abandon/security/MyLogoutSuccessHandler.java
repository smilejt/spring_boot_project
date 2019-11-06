package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @createData: 2019-11-06 15:57
 * @author: LongJunTao
 * @Description: 成功退出登录返回JSON
 */
@Component
public class MyLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyLogoutSuccessHandler.class);

    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        logger.info("[MyLogoutSuccessHandler].[onLogoutSuccess]----------> 执行退出登录成功返回");
        ResultEntity<String> authenticationResultEntity = new ResultEntity<>();
        authenticationResultEntity.setFlag(true);
        authenticationResultEntity.setCode(StatusCode.OK);
        authenticationResultEntity.setMessage(StatusCode.OK_TEXT);
        httpServletResponse.setContentType(CONTENT_TYPE);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(authenticationResultEntity));
        out.flush();
        out.close();
    }
}
