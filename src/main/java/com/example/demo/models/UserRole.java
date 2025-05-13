package com.example.demo.models;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {
    USER,       // Usuario normal
    ADMIN,      // Administrador con acceso total
    ORGANIZER,
    PLAYER;  // Organizador de torneos con permisos específicos

    @Override
    public String getAuthority() {
        return name(); // Retorna "USER", "ADMIN" o "ORGANIZER"
    }
}
