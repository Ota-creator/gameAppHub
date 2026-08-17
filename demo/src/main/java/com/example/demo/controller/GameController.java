package com.example.demo.controller;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import com.example.demo.service.GameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/games")
public class GameController {

    private final GameRepository gameRepository;
    private final GameService gameService;

    public GameController(
            GameRepository gameRepository,
            GameService gameService) {

        this.gameRepository = gameRepository;
        this.gameService = gameService;
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

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return gameRepository.save(game);
    }

    @PutMapping("/{id}")
    public Game update(
            @PathVariable Long id,
            @RequestBody Game game) {

        return gameService.update(id, game);
    }
}