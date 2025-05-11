package com.example.demo.services;

import com.example.demo.dtos.AuthResponse;
import com.example.demo.dtos.LoginRequest;
import com.example.demo.dtos.RegisterRequest;
import com.example.demo.enums.Role;
import com.example.demo.models.Organizer;
import com.example.demo.models.Player;
import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        User user;

        if (request.getRole() == Role.PLAYER) {
            Player player = new Player();
            player.setName(request.getName());
            player.setUsername(request.getUsername());
            player.setEmail(request.getEmail());
            player.setPassword(passwordEncoder.encode(request.getPassword()));
            player.setRole(request.getRole());
            player.setGoals(0);
            player.setTeam(null);
            player.setMatches(null);
            user = player;
        } else {
            Organizer organizer = new Organizer();
            organizer.setName(request.getName());
            organizer.setUsername(request.getUsername());
            organizer.setEmail(request.getEmail());
            organizer.setPassword(passwordEncoder.encode(request.getPassword()));
            organizer.setRole(request.getRole());
            organizer.setOrganizationName("Default Organization");
            user = organizer;
        }

        userRepository.save(user);
        String token = jwtService.generateToken(user);
        return new AuthResponse(token); // Devuelve el token
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        String token = jwtService.generateToken(user);
        return new AuthResponse(token); // Devuelve el token
    }
}
