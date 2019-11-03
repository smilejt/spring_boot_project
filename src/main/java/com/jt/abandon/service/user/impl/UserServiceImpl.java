package com.jt.abandon.service.user.impl;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.dao.user.RoleMapper;
import com.jt.abandon.dao.user.SystemUserMapper;
import com.jt.abandon.entity.user.RoleEntity;
import com.jt.abandon.entity.user.SystemUserEntity;
import com.jt.abandon.service.user.UserService;
import com.jt.abandon.utils.ResultEntity;
import com.jt.abandon.utils.StatusCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: LY
 * @Description: 用户相关Service实现类
 * @Date: 2019/11/3 11:12
 */
@Service
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Resource
    SystemUserMapper systemUserMapper;

    @Resource
    RoleMapper roleMapper;

    @Override
    public ResultEntity<SystemUserEntity> getUserByLoginName(String loginName) {

        ResultEntity<SystemUserEntity> resultEntity = new ResultEntity<>();

        try{
            //用户名为空,直接返回
            if (StringUtils.isEmpty(loginName)){
                logger.info("[UserServiceImpl].[getUserByLoginName]--------> 入参登录名为空");
                resultEntity.setFlag(false);
                resultEntity.setCode(StatusCode.LOGIN_ERROR);
                resultEntity.setMessage(StatusCode.LOGIN_ERROR_TEXT);
                return resultEntity;
            }

            //根据登录名查询用户
            Map<String,Object> params = new ConcurrentHashMap<>();
            params.put("loginName", loginName);
            logger.info("[UserServiceImpl].[getUserByLoginName]--------> 登录名查询用户开始,参数 params = {}", JSON.toJSONString(params));
            List<SystemUserEntity> resultList = systemUserMapper.selectByParams(params);
            logger.info("[UserServiceImpl].[getUserByLoginName]--------> 登录名查询用户结束，结果 resultList.size() = {} 条", resultList == null ? 0 : resultList.size());
            //查询结果空判断
            if (StringUtils.isEmpty(resultList) || resultList.size() != 1){
                resultEntity.setFlag(false);
                resultEntity.setCode(StatusCode.LOGIN_ERROR);
                resultEntity.setMessage(StatusCode.LOGIN_ERROR_TEXT);
                return resultEntity;
            }

            //查询用户角色信息
            SystemUserEntity systemUserEntity = resultList.get(0);
            logger.info("[UserServiceImpl].[getUserByLoginName]--------> 查询用户角色开始,参数 userId = {}", systemUserEntity.getUserId());
            List<RoleEntity> roleList = roleMapper.getRoleByUserId(systemUserEntity.getUserId());
            logger.info("[UserServiceImpl].[getUserByLoginName]--------> 查询用户角色结束，结果 roleList.size() = {} 条", roleList == null ? 0 : roleList.size());
            if (StringUtils.isEmpty(roleList) || roleList.size() <= 0){
                roleList = new ArrayList<>();
            }

            //封装用户角色信息
            systemUserEntity.setRoleList(roleList);

            //封装返回体
            resultEntity.setFlag(true);
            resultEntity.setData(systemUserEntity);
            logger.info("[UserServiceImpl].[getUserByLoginName]--------> 根据用户名查询用户信息结束");

        }catch (Exception e){
            logger.error("[UserServiceImpl].[getUserByLoginName]--------> 处理异常:", e);
            resultEntity.setFlag(false);
            resultEntity.setCode(StatusCode.ERROR);
            resultEntity.setMessage(StatusCode.ERROR_TEXT);
        }
        return resultEntity;
    }
}
