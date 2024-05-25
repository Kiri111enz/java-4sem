package com.example.prac14;

import com.example.prac14.models.Game;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class GameRepository {
    private HashMap<String, Game> games = new HashMap<>();

    public void addGame(Game game) {
        games.put(game.name(), game);
    }

    public void removeGameByName(String name) {
        games.remove(name);
    }

    public List<Game> getGames() {
        return games.values().stream().toList();
    }
}
