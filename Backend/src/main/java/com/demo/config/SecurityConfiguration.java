package com.demo.config;

import com.demo.security.JWTConfigure;
import com.demo.security.JWTTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final JWTTokenProvider jwtTokenProvider;

    public SecurityConfiguration( JWTTokenProvider jwtTokenProvider) {
        this.jwtTokenProvider = jwtTokenProvider;
    }
    @Bean
    public AuthenticationManager authenticationManager()throws Exception{
        return super.authenticationManager();
    }
//
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth)throws Exception{
//        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());  }
    @Override
    protected void configure(HttpSecurity https)throws Exception{
        https
                .csrf()
                .disable()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .authorizeRequests()
                .antMatchers("/api/login").permitAll()
                .antMatchers("/api/register").permitAll()
                .anyRequest().authenticated()
                .and()
                .cors()
                .and()
                .apply(new JWTConfigure(jwtTokenProvider));

    }
//    @Bean
//    PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder();
//    }
}
