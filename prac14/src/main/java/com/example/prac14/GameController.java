package com.example.prac14;

import com.example.prac14.models.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller()
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameRepository gameRepository;

    @PostMapping("/create")
    public @ResponseBody String create(@RequestBody Game game) {
        gameRepository.addGame(game);
        return "Success";
    }

    @DeleteMapping("/delete")
    public @ResponseBody String remove(@RequestBody DeleteRequestBody deleteRequestBody) {
        gameRepository.removeGameByName(deleteRequestBody.deleteValue());
        return "Success";
    }

    @GetMapping("/getAll")
    public @ResponseBody List<Game> getAllGames() {
        return gameRepository.getGames();
    }
}
