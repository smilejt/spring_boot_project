package com.jt.abandon.dao.user;

import com.jt.abandon.entity.user.ResourcesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LY
 * @Description: 资源Mapper
 * @Date: 2019/11/3 11:15
 */
@Mapper
@Repository
public interface ResourcesMapper {

    /**
     * 根据ID删除
     * @param resourceId 资源ID
     * @return 受改变数量
     */
    int deleteByPrimaryKey(String resourceId);

    /**
     * 新增资源(全字段)
     * @param record 资源对象
     * @return 受改变数量
     */
    int insert(ResourcesEntity record);

    /**
     * 新增资源(非全字段)
     * @param record 资源对象
     * @return 受改变数量
     */
    int insertSelective(ResourcesEntity record);

    /**
     * 根据ID查询资源对象
     * @param resourceId 资源ID
     * @return 查询结果
     */
    ResourcesEntity selectByPrimaryKey(String resourceId);

    /**
     * 根据ID集合查询资源对象
     * @param list
     * @return
     */
    List<ResourcesEntity> selectByRoleList(List<String> list);

    /**
     * 根据ID更新资源对象(非全字段)
     * @param record 资源对象
     * @return 受改变数量
     */
    int updateByPrimaryKeySelective(ResourcesEntity record);

    /**
     * 根据ID更新资源(全字段)
     * @param record 资源对象
     * @return 受改变数量
     */
    int updateByPrimaryKey(ResourcesEntity record);
}