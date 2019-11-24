package com.jt.abandon.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author: LY
 * @Description: Redis配置属性类
 * @Date: 2019/11/24 15:39
 */
@Component
@PropertySource("classpath:config/redisSource.properties")
public class RedisBaseProperties {

    private static final String DEFAULT_URL = "127.0.0.1";

    /**
     * Redis数据库地址
     */
    @Value("${redis.url}")
    private String redisUrl;
    /**
     * Redis数据库索引
     */
    @Value("${redis.database}")
    private Integer database;

    /**
     * 访问密码
     */
    @Value("${redis.password}")
    private String password;

    /**
     * 端口
     */
    @Value("${redis.port}")
    private Integer port;

    /**
     * 连接超时
     */
    @Value("${redis.timeout}")
    private Integer timeout;

    /**
     * 最大连接数
     */
    @Value("${pool.max-active}")
    private Integer maxActive;

    /**
     * 最大空闲连接
     */
    @Value("${pool.max-idle}")
    private Integer maxIdle;

    /**
     * 最大等待时间
     */
    @Value("${pool.max-wait}")
    private Integer maxWait;

    /**
     * 最小连接数
     */
    @Value("${pool.min-idle}")
    private Integer minIdle;

    public String getRedisUrl() {
        return redisUrl == null ? DEFAULT_URL : this.redisUrl;
    }

    public void setRedisUrl(String redisUrl) {
        this.redisUrl = redisUrl;
    }

    public Integer getDatabase() {
        return database == null ? 0 : this.database;
    }

    public void setDatabase(Integer database) {
        this.database = database;
    }

    public String getPassword() {
        return StringUtils.isEmpty(password) ? null : this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getPort() {
        return port == null ? 6379 : this.port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public Integer getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(Integer maxActive) {
        this.maxActive = maxActive;
    }

    public Integer getMaxIdle() {
        return maxIdle == null ? 0 : this.maxIdle;
    }

    public void setMaxIdle(Integer maxIdle) {
        this.maxIdle = maxIdle;
    }

    public Integer getMaxWait() {
        return maxWait == null ? 0 : this.maxWait;
    }

    public void setMaxWait(Integer maxWait) {
        this.maxWait = maxWait;
    }

    public Integer getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(Integer minIdle) {
        this.minIdle = minIdle;
    }
}
