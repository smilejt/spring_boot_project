package com.jt.abandon.controller.test;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.entity.test.TestEntity;
import com.jt.abandon.service.test.TestService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LY
 * @Description: 测试类
 * @Date: 2019/11/2 15:17
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    TestService testService;

    @RequestMapping(value = "getTest")
    @ResponseBody
    public List<TestEntity> getTest(){
        List<TestEntity> result = testService.getTestText();
        if (StringUtils.isEmpty(result) || result.size() <= 0){
            result = new ArrayList<>();
        }
        logger.info("[TestController].[getTest]--------->查询结果:{}", JSON.toJSON(result));
        return result;
    }
}
