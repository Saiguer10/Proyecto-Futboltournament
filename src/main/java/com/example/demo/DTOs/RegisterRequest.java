package com.example.demo.dtos;

import com.example.demo.enums.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
    private String name;
    private String username; // requerido
    private String email;
    private String password;
    private Role role;
}
