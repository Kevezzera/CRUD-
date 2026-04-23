package com.garciadev.crud_simples.controller;

import com.garciadev.crud_simples.dto.UserDto;
import com.garciadev.crud_simples.dto.request.LoginRequest;
import com.garciadev.crud_simples.dto.request.RegisterRequest;
import com.garciadev.crud_simples.dto.response.LoginResponse;
import com.garciadev.crud_simples.dto.response.RegisterResponse;
import com.garciadev.crud_simples.entity.UserEntity;
import com.garciadev.crud_simples.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AuthController {

    final UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginRequest loginRequest){
        return null;
    }

    public ResponseEntity<RegisterResponse> register(@Valid @RequestBody RegisterRequest request){
        UserEntity newUser = new UserEntity();
        newUser.setName(request.name());
        newUser.setEmail(request.email());
        newUser.setPassword(request.password());
        userRepository.save(newUser);
        return ResponseEntity.ok(new RegisterResponse(newUser.getName(), newUser.getEmail()));
    }
}
