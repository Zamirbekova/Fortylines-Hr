package com.example.fortylineshr.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    HEADOF,
    ADMIN,
    EMPLOYEE;

    @Override
    public String getAuthority() {
        return this.name();
    }
}
