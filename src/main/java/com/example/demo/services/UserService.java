package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    // Método para obtener un usuario por su ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // Método para crear un nuevo usuario
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // Método para eliminar un usuario por su ID
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }


}
