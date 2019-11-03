package com.jt.abandon.service.test.impl;

import com.jt.abandon.dao.test.TestMapper;
import com.jt.abandon.entity.test.TestEntity;
import com.jt.abandon.service.test.TestService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LY
 * @Description: 测试Service实现类
 * @Date: 2019/11/2 15:28
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    TestMapper testMapper;

    @Override
    public List<TestEntity> getTestText() {
        List<TestEntity> result = testMapper.selectText();
        if (StringUtils.isEmpty(result) || result.size() <= 0){
            result = new ArrayList<>();
        }
        return result;
    }
}
