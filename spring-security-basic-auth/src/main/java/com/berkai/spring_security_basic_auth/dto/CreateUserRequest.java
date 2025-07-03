package com.berkai.spring_security_basic_auth.dto;

public record CreateUserRequest(
        String name,
        String username,
        String password) {}
