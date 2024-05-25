package com.example.prac14;

import com.example.prac14.models.Game;
import com.example.prac14.models.GameAuthor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class GameAuthorRepository {
    private HashMap<String, GameAuthor> gameAuthors = new HashMap<>();

    public void addGameAuthor(GameAuthor gameAuthor) {
        gameAuthors.put(gameAuthor.nickname(), gameAuthor);
    }

    public void removeGameAuthorByName(String name) {
        gameAuthors.remove(name);
    }

    public List<GameAuthor> getGameAuthors() {
        return gameAuthors.values().stream().toList();
    }
}
