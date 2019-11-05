package com.jt.abandon.controller.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: LY
 * @Description:
 * @Date: 2019/11/5 21:04
 */
public class TestMain {

    private static final Logger logger = LoggerFactory.getLogger(TestMain.class);

    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        logger.info("加密后的密码:{}",bCryptPasswordEncoder.encode("admin"));
        logger.info("验证密码结果:{}",bCryptPasswordEncoder.matches("admin","$2a$10$eID80yJRtyqosPtL0oY5FeCgQzNpaGaJ1ZbWVh.6WLmBUkH.aBBRa"));
    }
}
