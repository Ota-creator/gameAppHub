package com.example.demo.controller;

import com.example.demo.model.Game;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Gamecontroller {

    @GetMapping("/api/games")
    public List<Game> getGames() {

        return List.of(
                new Game(1, "VALORANT"),
                new Game(2, "League of Legends")
        );
    }
}