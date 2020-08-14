package com.chenjh.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userService;

    @Autowired
    private UserLoginAuthenticationFailureHandler userLoginAuthenticationFailureHandler;//验证失败的处理类

    @Autowired
    private UserLoginAuthenticationSuccessHandler userLoginAuthenticationSuccessHandler;//验证成功的处理类

    @Autowired
    private AccessDeniedHandler accessDeniedHandlerImpl;//无权限的处理类

    /**
     * 指定userService
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/shop/edit").hasAuthority("店铺:修改")
                .antMatchers("/shop/**").hasRole("超级管理员")// 需要对应的角色才能访问
                .antMatchers("/static/**", "/jq/**")//静态资源等不需要验证
                .permitAll();//不需要身份认证

        //路由策略和访问权限的简单配置
        http.formLogin()  //启用默认登录页面
                //.failureForwardUrl("/login")  //登录失败返回url
                //.defaultSuccessUrl("/")  //登录成功跳转
                .loginPage("/toLogin")  //自定义登陆页
                .loginProcessingUrl("/login")  //点了登录按钮执行的方法
                .failureHandler(userLoginAuthenticationFailureHandler)//验证失败处理
                .successHandler(userLoginAuthenticationSuccessHandler)//验证成功处理
                .permitAll();  //登录页面全部可以访问

        //配置无权限页面过滤器
        http.exceptionHandling().accessDeniedHandler(accessDeniedHandlerImpl);
        http.cors().and().csrf().disable();

        //解决中文乱码问题
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("UTF-8"); filter.setForceEncoding(true);
        http.addFilterBefore(filter,CsrfFilter.class);

        super.configure(http);
    }



}
