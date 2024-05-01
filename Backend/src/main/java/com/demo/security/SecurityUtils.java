package com.demo.security;

import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public final class SecurityUtils {
    private SecurityUtils(){
    }
    public static Optional<String> getCurrentUser(){
        SecurityContext securityContext=SecurityContextHolder.getContext();
        return Optional.of(securityContext.getAuthentication())
                .map(authentication -> {
                    if (authentication.getPrincipal() instanceof UserDetails){
                        UserDetails userDetails=(UserDetails) authentication.getPrincipal();
                        userDetails.getUsername();
                    }else if (authentication.getPrincipal() instanceof String){
                        return (String) authentication.getPrincipal();
                    }return null;
                });
    }
}
