package com.example.demo.service;

import com.example.demo.model.Game;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    public Game getGameById(int id) {

        if (id == 1) {
            return new Game(1, "VALORANT");
        }

        if (id == 2) {
            return new Game(2, "League of Legends");
        }

        return null;
    }
}