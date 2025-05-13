package com.example.demo.controllers;

import com.example.demo.models.Match;
import com.example.demo.repositories.MatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/matches")
@RequiredArgsConstructor
public class MatchController {

    private final MatchRepository matchRepository;

    @GetMapping
    public List<Match> getAllMatches() {
        return matchRepository.findAll();
    }

    @GetMapping("/{id}")
    public Match getMatchById(@PathVariable Long id) {
        return matchRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Match createMatch(@RequestBody Match match) {
        return matchRepository.save(match);
    }


    @DeleteMapping("/{id}")
    public void deleteMatch(@PathVariable Long id) {
        matchRepository.deleteById(id);
    }
}
