package com.berkai.spring_security_basic_auth.model;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER,
    ADMIN,
    MOD;

    @Override
    public String getAuthority() {
        return name();
    }
}
