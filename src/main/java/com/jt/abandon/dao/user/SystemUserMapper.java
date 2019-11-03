package com.jt.abandon.dao.user;

import com.jt.abandon.entity.user.SystemUserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @Author: LY
 * @Description: 用户Mapper
 * @Date: 2019/11/3 11:15
 */
@Mapper
@Repository
public interface SystemUserMapper {

    /**
     * 根据用户ID删除
     * @param userId 用户ID
     * @return 受改变数量
     */
    int deleteByPrimaryKey(String userId);

    /**
     * 全字段新增用户
     * @param record 用户实体对象
     * @return 受改变数量
     */
    int insert(SystemUserEntity record);

    /**
     * 新增用户(非全字段)
     * @param record 用户实体
     * @return 受改变数量
     */
    int insertSelective(SystemUserEntity record);

    /**
     * 根据用户ID查询用户
     * @param userId 用户ID
     * @return 用户对象
     */
    SystemUserEntity selectByPrimaryKey(String userId);

    /**
     * 根据参数查询用户信息(仅查询正常用户)
     * @param params 查询参数
     * @return 查询结果
     */
    List<SystemUserEntity> selectByParams(Map<String,Object> params);

    /**
     * 根据ID更新
     * @param record 用户实体
     * @return 受改变数量
     */
    int updateByPrimaryKeySelective(SystemUserEntity record);

    /**
     * 根据ID更新
     * @param record 用户实体
     * @return 受改变数量
     */
    int updateByPrimaryKey(SystemUserEntity record);
}