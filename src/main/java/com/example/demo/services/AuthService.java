package com.example.demo.services;

import com.example.demo.DTOs.LoginRequest;
import com.example.demo.DTOs.RegisterRequest;
import com.example.demo.DTOs.UserResponse;
import com.example.demo.config.security.jwt.JwtService;
import com.example.demo.models.Organizer;
import com.example.demo.models.Player;
import com.example.demo.models.User;
import com.example.demo.models.UserRole;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public UserResponse register(RegisterRequest request) {
        UserRole role = UserRole.valueOf(request.getRole().toUpperCase());

        User user;
        System.out.println("ESTO ES ROLE: " + role);


        switch (role) {
            case PLAYER:
                user = Player.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .role(role)
                        // Puedes agregar valores por defecto o extender el DTO para incluirlos:
                        .position("N/A")
                        .teamName("N/A")
                        .goals(0)
                        .build();
                break;

            case ORGANIZER:
                user = Organizer.builder()
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .email(request.getEmail())
                        .role(role)
                        .organizationName("N/A") // o añade este campo al DTO
                        .build();
                break;

            default:
                throw new IllegalArgumentException("Rol de usuario no válido");
        }

        userRepository.save(user);

        /*String token = jwtService.generateToken(
                new org.springframework.security.core.userdetails.User(
                        user.getUsername(),
                        user.getPassword(),
                        user.getAuthorities()
                )
        );*/

        return UserResponse.builder()
                .username(user.getUsername())
                .role(user.getRole().name())
                /*     .token(token)*/
                .build();
    }


    public UserResponse login(LoginRequest request) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        System.out.println("");
        org.springframework.security.core.userdetails.User principal =
                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        User user = userRepository.findByUsername(principal.getUsername())
                .orElseThrow(() -> new RuntimeException("User not found"));

        String token = jwtService.generateToken(principal);

        return UserResponse.builder()
                .username(user.getUsername())
                .role(user.getRole().name())
                .token(token)
                .build();
    }
}


