package com.example.demo.controllers;

import com.example.demo.config.security.jwt.JwtAuthenticationFilter;
import com.example.demo.models.Team;
import com.example.demo.repositories.TeamRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamController.class)
@AutoConfigureMockMvc(addFilters = false)
public class TeamControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamRepository teamRepository;

    @MockBean
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    private Team mockTeam() {
        Team team = new Team();
        team.setId(1L);
        team.setName("Los Campeones");
        // Elimina team.setCity() si no existe la propiedad
        return team;
    }
    @Test
    void testGetAllTeams() throws Exception {
        Mockito.when(teamRepository.findAll()).thenReturn(List.of(mockTeam()));

        mockMvc.perform(get("/api/teams"))
                .andExpect(status().isOk());
    }

    @Test
    void testGetTeamById() throws Exception {
        Mockito.when(teamRepository.findById(1L)).thenReturn(Optional.of(mockTeam()));

        mockMvc.perform(get("/api/teams/1"))
                .andExpect(status().isOk());
    }
}

