package com.demo.security;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JWTConfigure extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final JWTTokenProvider jwtTokenProvider;

    public JWTConfigure(JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Override
    public void configure(HttpSecurity httpSecurity){
        JWTTokenFilter jwtTokenFilter=new JWTTokenFilter(jwtTokenProvider);
        httpSecurity.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }
}
