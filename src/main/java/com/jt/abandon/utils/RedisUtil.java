package com.jt.abandon.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.params.SetParams;

import javax.annotation.Resource;

/**
 * @Author: LY
 * @Description: Redis帮助类
 * @Date: 2019/11/24 17:40
 */
@Component
public class RedisUtil {

    private static final Logger logger = LoggerFactory.getLogger(RedisUtil.class);

    @Resource
    private JedisPool jedisPool;

    /**
     * 从redis连接池取得实例
     *
     * @return 结果
     */
    private Jedis getRedis() {
        Jedis jedis;
        jedis = jedisPool.getResource();
        return jedis;
    }

    /**
     * 根据key查看是否存在
     *
     * @param key key
     * @return 结果
     */
    public String getCacheValue(String key) {
        logger.info("[RedisUtil].[getCacheValue]-------->入参 key = {}", key);
        String result;
        try (Jedis jedis = this.getRedis()) {
            result = jedis.get(key);
            logger.info("[RedisUtil].[getCacheValue]-------->返回 result = {}", result);
        } catch (Exception e) {
            logger.error("[RedisUtil].[getCacheValue]-------->处理异常", e);
            result = null;
        }
        return result;
    }

    /**
     * 更新key的value
     *
     * @param key   键
     * @param value 值
     * @param time  过期时间(毫秒)
     * @return 执行结果
     */
    public String updateCache(String key, String value, Long time) {
        logger.info("[RedisUtil].[updateCache]-------->入参key = {}, value = {}, time = {}", key, value, time);
        String result;
        Jedis jedis = null;
        try {
            SetParams setParams = new SetParams();
            //设置过期时间
            if (!StringUtils.isEmpty(time)) {
                setParams.px(time);
            }
            jedis = this.getRedis();
            result = jedis.set(key, value, setParams);
            logger.info("[RedisUtil].[updateCache]-------->返回 result = {}", result);
        } catch (Exception e) {
            logger.error("[RedisUtil].[updateCache]-------->处理异常", e);
            result = "ERROR";
        } finally {
            if (null != jedis) {
                jedis.close();
            }
        }
        return result;
    }

    /**
     * 根据key删除缓存
     *
     * @param key key
     * @return 结果
     */
    public Long deleteCacheByKey(String key) {
        logger.info("[RedisUtil].[deleteCacheByKey]-------->入参 key = {}", key);
        Long result;
        try (Jedis jedis = this.getRedis()) {
            result = jedis.del(key);
            logger.info("[RedisUtil].[deleteCacheByKey]-------->返回 result = {}", result);
        } catch (Exception e) {
            logger.error("[RedisUtil].[deleteCacheByKey]-------->处理异常", e);
            result = null;
        }
        return result;
    }
}
