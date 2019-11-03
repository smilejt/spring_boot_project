package com.jt.abandon.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.dao.user.ResourcesMapper;
import com.jt.abandon.entity.user.ResourcesEntity;
import com.jt.abandon.service.user.ResourcesService;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LY
 * @Description:
 * @Date: 2019/11/3 21:29
 */
@Service
public class ResourcesServiceImpl implements ResourcesService {

    private static final Logger logger = LoggerFactory.getLogger(ResourcesServiceImpl.class);

    @Resource
    ResourcesMapper resourcesMapper;

    @Override
    public ResultEntity<List<ResourcesEntity>> selectByRoleList(List<String> list) {
        ResultEntity<List<ResourcesEntity>> resultEntity = new ResultEntity<>();
        try{
            if (StringUtils.isEmpty(list) || list.size() <= 0){
                logger.info("[ResourcesServiceImpl].[selectByRoleList]--------> 入参list为空");
                resultEntity.setFlag(false);
                resultEntity.setCode(StatusCode.ERROR);
                resultEntity.setMessage(StatusCode.ERROR_TEXT);
                return resultEntity;
            }

            logger.info("[ResourcesServiceImpl].[selectByRoleList]--------> 根据ID集合查询资源对象开始,参数 params = {}", JSON.toJSONString(list));
            List<ResourcesEntity> resultList = resourcesMapper.selectByRoleList(list);
            logger.info("[ResourcesServiceImpl].[selectByRoleList]--------> 根据ID集合查询资源对象结束,结果 resultList.size() = {} 条", resultList == null ? 0 : resultList.size());

            if (StringUtils.isEmpty(resultList) || resultList.size() <= 0){
                resultList = new ArrayList<>();
            }

            resultEntity.setData(resultList);
            logger.info("[ResourcesServiceImpl].[selectByRoleList]--------> 根据ID集合查询资源对象结束");
        }catch (Exception e){
            logger.error("[ResourcesServiceImpl].[selectByRoleList]--------> 处理异常:", e);
            resultEntity.setFlag(false);
            resultEntity.setCode(StatusCode.ERROR);
            resultEntity.setMessage(StatusCode.ERROR_TEXT);
        }

        return resultEntity;
    }
}
