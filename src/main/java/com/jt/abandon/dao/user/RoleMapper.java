package com.jt.abandon.dao.user;

import com.jt.abandon.entity.user.RoleEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LY
 * @Description: 角色Mapper
 * @Date: 2019/11/3 11:15
 */
@Mapper
@Repository
public interface RoleMapper {

    /**
     * 根据ID删除资源
     * @param roleId 角色ID
     * @return 受改变数量
     */
    int deleteByPrimaryKey(String roleId);

    /**
     * 新增角色(全字段)
     * @param record 角色实体
     * @return 受改变数量
     */
    int insert(RoleEntity record);

    /**
     * 新增角色(非全字段)
     * @param record 角色实体
     * @return 受改变数量
     */
    int insertSelective(RoleEntity record);

    /**
     * 根据角色ID查询角色实体
     * @param roleId 角色ID
     * @return 角色实体
     */
    RoleEntity selectByPrimaryKey(String roleId);

    /**
     * 根据角色ID更新角色信息(非全字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int updateByPrimaryKeySelective(RoleEntity record);

    /**
     * 根据角色ID更新角色信息(全字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int updateByPrimaryKey(RoleEntity record);

    /**
     * 根据用户ID查询角色信息
     * @param userId 用户ID
     * @return 角色List
     */
    List<RoleEntity> getRoleByUserId(String userId);
}