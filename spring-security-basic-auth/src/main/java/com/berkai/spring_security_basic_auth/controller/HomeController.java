package com.berkai.spring_security_basic_auth.controller;

import com.berkai.spring_security_basic_auth.dto.CreateUserRequest;
import com.berkai.spring_security_basic_auth.model.User;
import com.berkai.spring_security_basic_auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final UserService userService;

    @GetMapping("/hello")
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello, authenticated user!");
    }

    @GetMapping("/")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Welcome to the secured application!");
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody CreateUserRequest user){
        User created = userService.createUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }
}

