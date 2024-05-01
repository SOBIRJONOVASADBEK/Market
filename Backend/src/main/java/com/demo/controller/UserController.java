package com.demo.controller;

import com.demo.domain.User;
import com.demo.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {
private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user){
        if (!checkedPassword(user.getPassword())){
            return new ResponseEntity("Parol uzunligi 8 dan kam", HttpStatus.BAD_REQUEST);
        }if (userService.checkedUser(user.getUserName())){
            return new ResponseEntity("Bu User Oldin Ro'yxatdan O'tgan", HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(userService.createUser(user));
    }
    private Boolean checkedPassword(String password){
       return password.length()>8;
    }
}
