package com.example.demo.controllers;

import com.example.demo.models.Player;
import com.example.demo.repositories.PlayerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/players")
@RequiredArgsConstructor
public class PlayerController {

    private final PlayerRepository playerRepository;

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Player createPlayer(@RequestBody Player player) {
        return playerRepository.save(player);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player playerDetails) {
        Player player = playerRepository.findById(id).orElseThrow();
        player.setPosition(playerDetails.getPosition());
        player.setGoals(playerDetails.getGoals());
        player.setTeam(playerDetails.getTeam());
        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable Long id) {
        playerRepository.deleteById(id);
    }
}
