package com.example.demo.enums;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    PLAYER,
    ORGANIZER;

    @Override
    public String getAuthority() {
        return name(); // Devuelve el nombre del enum como la autoridad.
    }
}
