package com.jt.abandon.entity.test;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Author: LY
 * @Description:
 * @Date: 2019/11/2 15:21
 */
@ApiModel("数据库测试实体")
public class TestEntity {

    @ApiModelProperty("主键字段")
    private Integer id;

    @ApiModelProperty("文字字段")
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
