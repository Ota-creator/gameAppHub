package com.example.demo.controller;

import com.example.demo.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;
import com.example.demo.service.GameService;

import java.util.List;

@RestController
public class GameController {

    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping("/api/games")
    public List<Game> getGames() {

        return List.of(
                new Game(1, "VALORANT"),
                new Game(2, "League of Legends")
        );
    }

    @GetMapping("/api/games/{id}")
    public Game getGame(@PathVariable int id) {

        Game game = gameService.getGameById(id);

        if (game == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Game not found"
            );
        }

        return game;
    }
}