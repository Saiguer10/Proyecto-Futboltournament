package com.example.demo.DTOs;

public class RegisterRequest {
    private String username;
    private String password;
    private String email;
    private String role;  // Añadir este campo para almacenar el rol

    // Campos adicionales para Player y Organizer
    private String position;   // Solo para Player
    private String teamName;   // Solo para Player
    private int goals;         // Solo para Player
    private String organizationName; // Solo para Organizer

    // Constructor vacío (si es necesario para la deserialización)
    public RegisterRequest() {}

    // Constructor con parámetros
    public RegisterRequest(String username, String password, String email, String role,
                           String position, String teamName, int goals, String organizationName) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
        this.position = position;
        this.teamName = teamName;
        this.goals = goals;
        this.organizationName = organizationName;
    }

    // Getters y Setters
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;  // Getter para obtener el rol
    }

    public void setRole(String role) {
        this.role = role;  // Setter para establecer el rol
    }

    // Getters y Setters adicionales
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }
}

