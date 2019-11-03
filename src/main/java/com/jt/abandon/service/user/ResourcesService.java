package com.jt.abandon.service.user;

import com.jt.abandon.entity.user.ResourcesEntity;
import com.jt.abandon.utils.ResultEntity;

import java.util.List;

/**
 * @Author: LY
 * @Description:
 * @Date: 2019/11/3 21:28
 */
public interface ResourcesService {

    /**
     * 根据ID集合查询资源对象
     * @param list
     * @return
     */
    ResultEntity<List<ResourcesEntity>> selectByRoleList(List<String> list);
}
