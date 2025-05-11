package com.example.demo.controllers;

import com.example.demo.dtos.AuthResponse;
import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.RegisterRequest;
import com.example.demo.controllers.AuthController;
import com.example.demo.enums.Role;
import com.example.demo.services.AuthenticationService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class AuthControllerTest {

    @InjectMocks
    private AuthController authController;

    @Mock
    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testRegister() {
        RegisterRequest request = new RegisterRequest();
        request.setName("Carlos");
        request.setEmail("carlos@test.com");
        request.setUsername("carlos123");
        request.setPassword("1234");
        request.setRole(Role.PLAYER);  // Asegúrate de que Role esté disponible aquí

        AuthResponse mockResponse = new AuthResponse("fake-jwt-token");

        when(authenticationService.register(request)).thenReturn(mockResponse);

        AuthResponse response = authController.register(request);

        assertEquals("fake-jwt-token", response.getToken());
        verify(authenticationService, times(1)).register(request);
    }

    @Test
    public void testLogin() {
        LoginRequest loginRequest = new LoginRequest("user@example.com", "password123");

        ResponseEntity<AuthResponse> response = authController.login(loginRequest);

        AuthResponse authResponse = response.getBody();

        assertNotNull(authResponse);
        assertEquals("Expected JWT", authResponse.getToken());
    }
}

