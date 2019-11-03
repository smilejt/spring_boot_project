package com.jt.abandon.service.user;

import com.jt.abandon.entity.user.SystemUserEntity;
import com.jt.abandon.utils.ResultEntity;

/**
 * @Author: LY
 * @Description: 用户相关Service
 * @Date: 2019/11/3 11:06
 */
public interface UserService {

    /**
     * 根据登录名查询用户
     * @param loginName 登录名
     * @return 查询结果
     */
    ResultEntity<SystemUserEntity> getUserByLoginName(String loginName);
}
