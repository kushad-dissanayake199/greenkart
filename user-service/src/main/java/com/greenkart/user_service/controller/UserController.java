package com.greenkart.user_service.controller;

import com.greenkart.user_service.dto.AuthRequest;
import com.greenkart.user_service.model.User;
import com.greenkart.user_service.service.UserService;
import com.greenkart.user_service.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/auth")
public class UserController {
    private final UserService service;
    private final JwtUtil jwtUtil;

    @PostMapping("/register")
    public Mono<User> register(@RequestBody User user) {
        return service.register(user);
    }

    @PostMapping("/login")
    public Mono<String> login(@RequestBody AuthRequest request) {
        return service.authenticate(request.getEmail(), request.getPassword())
                .map(user -> jwtUtil.generateToken(user.getEmail(), user.getRole()));
    }
}