package com.jt.abandon.config;

import com.jt.abandon.security.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @Author: LY
 * @Description: Spring Security配置
 * prePostEnabled = true 启用方法级别的权限认证
 * @Date: 2019/11/3 10:59
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    MyUserDetailsServiceImpl myUserDetailsService;

    @Resource
    private MyAuthenticationSuccessHandler myAuthenticationSuccessHandler;
    @Resource
    private MyAuthenticationFailHandler myAuthenticationFailHandler;
    @Resource
    private MyAuthenticationEntryPoint myAuthenticationEntryPoint;
    @Resource
    private MyAccessDeniedHandler myAccessDeniedHandler;
    @Resource
    private MyLogoutSuccessHandler myLogoutSuccessHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                //未登录拦截
                .httpBasic().authenticationEntryPoint(myAuthenticationEntryPoint)
                .and()
                .authorizeRequests()
                //指定'/test/getTest'跳过验证
                .antMatchers("/test/getTest").permitAll()
                .anyRequest().authenticated()
                //指定登录URL
                .and()
                .formLogin().loginProcessingUrl("/login")
                //登录验证成功
                .successHandler(myAuthenticationSuccessHandler)
                //登录验证失败
                .failureHandler(myAuthenticationFailHandler)
                //没有权限
                .and()
                .exceptionHandling()
                //没有权限，返回json
                .accessDeniedHandler(myAccessDeniedHandler)
                .and()
                .logout()
                //退出成功，返回json
                .logoutSuccessHandler(myLogoutSuccessHandler)
                // 禁用csrf防御机制(跨域请求伪造)，这么做在测试和开发会比较方便
                .and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
