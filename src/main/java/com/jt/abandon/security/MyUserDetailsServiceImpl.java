package com.jt.abandon.security;

import com.alibaba.fastjson.JSON;
import com.jt.abandon.entity.user.ResourcesEntity;
import com.jt.abandon.entity.user.RoleEntity;
import com.jt.abandon.entity.user.SystemUserEntity;
import com.jt.abandon.service.user.ResourcesService;
import com.jt.abandon.service.user.UserService;
import com.jt.abandon.utils.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: LY
 * @Description: Spring Security认证过程
 * @Date: 2019/11/3 11:15
 */
@Service
public class MyUserDetailsServiceImpl implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsServiceImpl.class);

    @Resource
    UserService userService;

    @Resource
    ResourcesService resourcesService;

    @Override
    public UserDetails loadUserByUsername(String loginName) throws UsernameNotFoundException {
        logger.info("[MyUserDetailsServiceImpl].[loadUserByUsername]--------> Spring Security用户认证开始，loginName = {}", loginName);
        //根据登录名查询用户
        ResultEntity<SystemUserEntity> result = userService.getUserByLoginName(loginName);
        logger.info("[MyUserDetailsServiceImpl].[loadUserByUsername]--------> 登录名查询结束，结果 result = {}", JSON.toJSONString(result));
        if (StringUtils.isEmpty(result) || !result.isFlag() || StringUtils.isEmpty(result.getData())){
            logger.info("[MyUserDetailsServiceImpl].[loadUserByUsername]--------> 登录名未查询到结果，loginName = {}", loginName);
            //未查询到用户,抛出异常
            throw new UsernameNotFoundException(loginName);
        }

        SystemUserEntity systemUserEntity = result.getData();

        //查用角色对应资源
        List<String> params = new ArrayList<>();
        if (!StringUtils.isEmpty(systemUserEntity.getRoleList()) && systemUserEntity.getRoleList().size() > 0){
            for (RoleEntity roleEntity: systemUserEntity.getRoleList()) {
                params.add(roleEntity.getRoleId());
            }
        }
        logger.info("[MyUserDetailsServiceImpl].[loadUserByUsername]--------> 查询用户资源列表开始，入参 params = {}", JSON.toJSONString(params));
        ResultEntity<List<ResourcesEntity>> resourcesResult = resourcesService.selectByRoleList(params);
        logger.info("[MyUserDetailsServiceImpl].[loadUserByUsername]--------> 查询用户资源列表结束，返回 resourcesResult = {}", JSON.toJSONString(resourcesResult));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        if (resourcesResult.isFlag() && resourcesResult.getData() != null && resourcesResult.getData().size() > 0){
            for (ResourcesEntity res : resourcesResult.getData()) {
                authorities.add(new SimpleGrantedAuthority(res.getResourceCode()));
            }
        }

        return new User(systemUserEntity.getUsername(), systemUserEntity.getPassword(), authorities);
    }
}
