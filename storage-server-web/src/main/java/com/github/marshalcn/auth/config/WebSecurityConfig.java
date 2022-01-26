package com.github.marshalcn.auth.config;

import com.github.marshalcn.auth.handler.UserAuthSuccessHandler;
import com.github.marshalcn.config.MD5PasswordEncoder;
import com.github.marshalcn.auth.manager.provider.MyAuthenticationProvider;
import com.github.marshalcn.auth.manager.UserAuthenticationManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.annotation.Resource;

/**
 * @author madechao
 * @menu
 * @description
 * @createTime 17:22 2022/1/18
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Resource
//    private BCryptPasswordEncoder passwordEncoder;
    @Resource
    private UserDetailsService userDetailsService;
    @Resource
    private UserAuthSuccessHandler userAuthSuccessHandler;
    @Resource
    private UserAuthenticationManager authenticationManager;
    @Resource
    private MyAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.authenticationProvider(authenticationProvider);
        auth.authenticationProvider(new DaoAuthenticationProvider());
        auth.parentAuthenticationManager(authenticationManager);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .and().formLogin()
                .successHandler(userAuthSuccessHandler)
//                .antMatchers("/login/**").permitAll()
                .permitAll()
//                .successForwardUrl("/home/hello")
                .and().logout().permitAll()
                .and()
                .csrf().disable();
    }

    @Override
    protected UserDetailsService userDetailsService(){
        return userDetailsService;
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new MD5PasswordEncoder();
    }
}
