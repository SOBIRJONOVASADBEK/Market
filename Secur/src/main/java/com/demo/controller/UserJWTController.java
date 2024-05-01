package com.demo.controller;

import com.demo.controller.vm.LoginVm;
import com.demo.domain.User;
import com.demo.repository.UserRepository;
import com.demo.security.JWTTokenProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserJWTController {
    private final AuthenticationManager authenticationManager;
    private final JWTTokenProvider jwtTokenProvider;
    private final UserRepository userRepository;

    public UserJWTController(AuthenticationManager authenticationManager, JWTTokenProvider jwtTokenProvider, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userRepository = userRepository;
    }
    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginVm loginVm){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginVm.getUsername(),loginVm.getPassword()));
        User user=userRepository.findByUserName(loginVm.getUsername());
        if (user==null){
            throw new UsernameNotFoundException("Bu foydalanuvchi mavjud emas");

        }
        String token= jwtTokenProvider.createToken(user.getUserName(),user.getRoles());
        Map<Object,Object> map=new HashMap<>();
        map.put("username",user.getUserName());
        map.put("token",token);
        return ResponseEntity.ok(map);
    }
}
