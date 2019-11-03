package com.jt.abandon.service.test;

import com.jt.abandon.entity.test.TestEntity;

import java.util.List;

/**
 * @Author: LY
 * @Description: 测试Service
 * @Date: 2019/11/2 15:28
 */
public interface TestService {

    /**
     * 测试方法
     * @return TestEntity的List
     */
    List<TestEntity> getTestText();
}
