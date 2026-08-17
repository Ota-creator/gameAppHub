package com.example.demo.service;

import com.example.demo.entity.Game;
import com.example.demo.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    public Game findById(Long id) {
        return gameRepository.findById(id)
                .orElseThrow();
    }

    public Game save(Game game) {
        return gameRepository.save(game);
    }

    public Game update(Long id, Game game) {

        Game existingGame = gameRepository.findById(id)
                .orElseThrow();

        existingGame.setName(game.getName());
        existingGame.setGenre(game.getGenre());

        return gameRepository.save(existingGame);
    }
}
