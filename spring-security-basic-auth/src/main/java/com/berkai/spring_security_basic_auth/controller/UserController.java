package com.berkai.spring_security_basic_auth.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/profile")
    public ResponseEntity<String> getUserProfile() {
        return ResponseEntity.ok("Welcome to your user profile!");
    }

    @GetMapping("/info")
    public ResponseEntity<String> getUserInfo() {
        return ResponseEntity.ok("Some general user info accessible by USER or ADMIN.");
    }
}
