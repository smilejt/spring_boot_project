package com.jt.abandon.controller.test;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.entity.test.TestEntity;
import com.jt.abandon.service.test.TestService;
import com.jt.abandon.utils.RedisUtil;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: LY
 * @Description: 测试类
 * @Date: 2019/11/2 15:17
 */
@Api(tags = "测试接口")
@Controller
@RequestMapping(value = "/test")
public class TestController {

    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    @Resource
    TestService testService;

    @Resource
    RedisUtil redisUtil;

    /**
     * 测试方法
     *
     * @return 查询结果
     */
    @ApiOperation("测试获取数据库链接")
    @RequestMapping(value = "getTest", method = RequestMethod.GET)
    @ResponseBody
    public List<TestEntity> getTest() {
        List<TestEntity> result = testService.getTestText();
        logger.info("[TestController].[getTest]--------->查询结果:{}", JSON.toJSON(result));

        String testUserListKey = "testUserList";
        logger.info("[TestController].[getTest]--------->调用Redis更新开始: testUserListKey = {}, JsonString = {}", testUserListKey, JSON.toJSONString(result));
        //Redis写入一个有失效时间的数据
        String redisResult = redisUtil.updateCache(testUserListKey, JSON.toJSONString(result), 50000L);
        logger.info("[TestController].[getTest]--------->调用Redis更新(有失效时间)结束, 执行结果 redisResult = {}", redisResult);
        //Redis写入一个无失效时间的数据
        redisResult = redisUtil.updateCache(testUserListKey + "1", JSON.toJSONString(result), null);
        logger.info("[TestController].[getTest]--------->调用Redis更新(无失效时间)结束, 执行结果 redisResult = {}", redisResult);
        //Redis查询Key是否存在
        logger.info("[TestController].[getTest]--------->调用Redis查询开始: key = {}", testUserListKey);
        redisResult = redisUtil.getCacheValue(testUserListKey);
        logger.info("[TestController].[getTest]--------->调用Redis查询(有失效时间)结束, 执行结果 redisResult = {}", redisResult);
        redisResult = redisUtil.getCacheValue(testUserListKey + "1");
        logger.info("[TestController].[getTest]--------->调用Redis查询(无失效时间)结束, 执行结果 redisResult = {}", redisResult);
        redisResult = redisUtil.getCacheValue(testUserListKey + "2");
        logger.info("[TestController].[getTest]--------->调用Redis查询(不存在)结束, 执行结果 redisResult = {}", redisResult);
        //Redis删除存在的Key
        Long redisDeleteResult = redisUtil.deleteCacheByKey(testUserListKey + "1");
        logger.info("[TestController].[getTest]--------->调用Redis删除(无失效时间)结束, 执行结果 redisDeleteResult = {}", redisDeleteResult);
        //Redis删除不存在的Key
        redisDeleteResult = redisUtil.deleteCacheByKey(testUserListKey + "2");
        logger.info("[TestController].[getTest]--------->调用Redis删除(无失效时间)结束, 执行结果 redisDeleteResult = {}", redisDeleteResult);
        return result;
    }

    @ApiOperation("测试security未登录拦截")
    @RequestMapping(value = "doFilter", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity doFilter() {
        ResultEntity<UserDetails> result = new ResultEntity<>();
        result.setFlag(true);
        result.setCode(StatusCode.OK);
        result.setMessage(StatusCode.OK_TEXT);
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        result.setData(userDetails);
        logger.info("[TestController].[doFilter]--------->拦截测试方法执行:{}", JSON.toJSON(result));
        return result;
    }
}
