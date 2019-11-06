package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @createData: 2019-11-06 15:39
 * @author: LongJunTao
 * @Description: 权限不足处理
 */
@Component
public class MyAccessDeniedHandler implements AccessDeniedHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyAccessDeniedHandler.class);

    private static final String CONTENT_TYPE = "application/json;charset=utf-8";

    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AccessDeniedException e) throws IOException, ServletException {
        logger.info("[MyAccessDeniedHandler].[handle]----------> 执行无权限返回");
        ResultEntity<String> authenticationResultEntity = new ResultEntity<>();
        authenticationResultEntity.setFlag(false);
        authenticationResultEntity.setCode(StatusCode.ACCESS_ERROR);
        authenticationResultEntity.setMessage(StatusCode.ACCESS_ERROR_TEXT);
        httpServletResponse.setContentType(CONTENT_TYPE);
        httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        PrintWriter out = httpServletResponse.getWriter();
        out.write(JSON.toJSONString(authenticationResultEntity));
        out.flush();
        out.close();
    }
}
