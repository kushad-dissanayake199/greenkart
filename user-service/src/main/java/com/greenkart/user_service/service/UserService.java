package com.greenkart.user_service.service;

import com.greenkart.user_service.model.User;
import com.greenkart.user_service.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private final PasswordEncoder encoder;

    public Mono<User> register(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        return repository.save(user);
    }

    public Mono<User> authenticate(String email, String rawPassword) {
        return repository.findByEmail(email)
                .filter(u -> encoder.matches(rawPassword, u.getPassword()));
    }
}