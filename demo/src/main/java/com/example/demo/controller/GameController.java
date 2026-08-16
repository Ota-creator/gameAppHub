package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @GetMapping
    public List<Game> getGames() {
        return gameRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable Long id) {

        Optional<Game> game = gameRepository.findById(id);

        return game.orElse(null);
    }
}