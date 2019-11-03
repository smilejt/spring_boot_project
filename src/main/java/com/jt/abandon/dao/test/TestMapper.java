package com.jt.abandon.dao.test;

import com.jt.abandon.entity.test.TestEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: LY
 * @Description: 测试Mapper
 * @Date: 2019/11/2 15:21
 */
@Mapper
@Repository
public interface TestMapper {

    /**
     * 删除
     * @param id 主键ID
     * @return 受改变数量
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增(全字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int insert(TestEntity record);

    /**
     * 新增(部分字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int insertSelective(TestEntity record);

    /**
     * 根据ID查询
     * @param id 主键ID
     * @return 查询到的实体对象
     */
    TestEntity selectByPrimaryKey(Integer id);

    /**
     * 根据主键更新(部分字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int updateByPrimaryKeySelective(TestEntity record);

    /**
     * 根据主键更新(全字段)
     * @param record 实体对象
     * @return 受改变数量
     */
    int updateByPrimaryKey(TestEntity record);

    /**
     * 测试查询方法
     * @return 查询结果List
     */
    List<TestEntity> selectText();
}