package com.jt.abandon;

import com.alibaba.druid.pool.DruidDataSource;
import com.jt.abandon.config.DataBaseProperties;
import com.jt.abandon.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Date;

/**
 * @Author: LY
 * @Description: SpringBoot启动类
 * @Date: 2019/11/2 14:58
 */
@SpringBootApplication
public class SpringBootProjectApplication {
    private static final Logger logger = LoggerFactory.getLogger(SpringBootProjectApplication.class);

    @Resource
    DataBaseProperties dataBaseProperties;

    @Bean
    public DataSource dateSource() {
        logger.info("---------------- DruidDataSource创建注入,时间{} ----------------", DateUtil.str(new Date(), DateUtil.FMT_Y_M_D_H_M_S));
        DruidDataSource druidDataSource = new DruidDataSource();
        //数据库地址
        logger.debug("数据库URL:{}",dataBaseProperties.getUrl());
        druidDataSource.setUrl(dataBaseProperties.getUrl());
        //数据库登录名
        logger.debug("数据库username:{}",dataBaseProperties.getUsername());
        druidDataSource.setUsername(dataBaseProperties.getUsername());
        //数据库密码
        logger.debug("数据库password:{}",dataBaseProperties.getPassword());
        druidDataSource.setPassword(dataBaseProperties.getPassword());
        //初始化数据库连接数
        druidDataSource.setInitialSize(dataBaseProperties.getInitialSize());
        //最小链接数
        druidDataSource.setMinIdle(dataBaseProperties.getMinIdle());
        //最大链接数
        druidDataSource.setMaxActive(dataBaseProperties.getMaxActive());
        //获取连接等待超时的时间
        druidDataSource.setMaxWait(dataBaseProperties.getMaxWait());
        //检测需要关闭的空闲连接的时间
        druidDataSource.setTimeBetweenEvictionRunsMillis(dataBaseProperties.getTimeBetweenEvictionRunsMillis());
        //连接在池中最小生存的时间
        druidDataSource.setMinEvictableIdleTimeMillis(dataBaseProperties.getMinEvictableIdleTimeMillis());
        druidDataSource.setValidationQuery(dataBaseProperties.getValidationQuery());
        druidDataSource.setTestWhileIdle(dataBaseProperties.isTestWhileIdle());
        druidDataSource.setTestOnBorrow(dataBaseProperties.isTestOnBorrow());
        druidDataSource.setTestOnReturn(dataBaseProperties.isTestOnReturn());
        druidDataSource.setPoolPreparedStatements(dataBaseProperties.isPoolPreparedStatements());
        druidDataSource.setMaxPoolPreparedStatementPerConnectionSize(dataBaseProperties.getMaxPoolPreparedStatementPerConnectionSize());
        return druidDataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootProjectApplication.class, args);
        logger.info("---------------- SpringBoot启动成功,时间{} ----------------", DateUtil.str(new Date(), DateUtil.FMT_Y_M_D_H_M_S));
    }
}
