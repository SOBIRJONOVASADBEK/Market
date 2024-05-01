package com.demo.controller;

import com.demo.domain.User;
import com.demo.security.SecurityUtils;
import com.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AccountController {
    private final UserService userService;

    public AccountController(UserService userService) {
        this.userService = userService;
    }
//    @GetMapping("/account")
//    public ResponseEntity<?> getAccount(){
//        return ResponseEntity.ok(userService.finfByUser("admin"));
//    }

}
