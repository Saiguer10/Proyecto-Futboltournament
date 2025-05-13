package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    private MockMvc mockMvc;

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private User user;

    // Clase concreta para pruebas
    public static class SimpleUser extends User {
        public SimpleUser(Long id, String username, String password, String email, UserRole role) {
            setId(id);
            setUsername(username);
            setPassword(password);
            setEmail(email);
            setRole(role);
        }
    }

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        // Crear un usuario de prueba con la clase concreta
        user = new SimpleUser(1L, "testuser", "password", "test@example.com", UserRole.USER);
    }

    @Test
    void testGetAllUsers() throws Exception {
        when(userService.getAllUsers()).thenReturn(Collections.singletonList(user));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].username").value(user.getUsername()));

        verify(userService, times(1)).getAllUsers();
    }

    @Test
    void testGetUserById() throws Exception {
        when(userService.getUserById(user.getId())).thenReturn(Optional.of(user));

        mockMvc.perform(get("/api/users/{id}", user.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value(user.getUsername()));

        verify(userService, times(1)).getUserById(user.getId());
    }

    @Test
    void testGetUserByIdNotFound() throws Exception {
        when(userService.getUserById(user.getId())).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/users/{id}", user.getId()))
                .andExpect(status().isNotFound());

        verify(userService, times(1)).getUserById(user.getId());
    }


}
