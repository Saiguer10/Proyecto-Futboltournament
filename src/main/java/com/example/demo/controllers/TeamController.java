package com.example.demo.controllers;

import com.example.demo.models.Team;
import com.example.demo.repositories.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/teams")
@RequiredArgsConstructor
public class TeamController {

    private final TeamRepository teamRepository;

    @GetMapping
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeamById(@PathVariable Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team teamDetails) {
        Team team = teamRepository.findById(id).orElseThrow();
        team.setName(teamDetails.getName());
        return teamRepository.save(team);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
    }
}
