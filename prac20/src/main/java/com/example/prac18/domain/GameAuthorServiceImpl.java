package com.example.prac18.domain;

import com.example.prac18.data.GameAuthorRepository;
import com.example.prac18.entities.GameAuthor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class GameAuthorServiceImpl implements GameAuthorService {
    @Autowired
    private GameAuthorRepository gameAuthorRepository;


    @Override
    public void addGameAuthor(GameAuthor gameAuthor) {
        log.info("Add game author");
        gameAuthorRepository.saveAndFlush(gameAuthor);
    }

    @Override
    public void removeGameAuthorByName(String name) {
        log.info("Remove game author");
        gameAuthorRepository.deleteGameAuthorByNickname(name);
    }

    @Override
    public List<GameAuthor> getGameAuthorByNickname(String nickname) {
        log.info("Get game author by nickname");
        return gameAuthorRepository.getGameAuthorsByNickname(nickname);
    }

    @Override
    public List<GameAuthor> getGameAuthorByBirthday(String birthday) {
        log.info("Get game author by birthday");
        return gameAuthorRepository.getGameAuthorsByBirthday(birthday);
    }

    @Override
    public GameAuthor getGameAuthorById(Long id) {
        log.info("Get game author by id");
        Optional<GameAuthor> gameAuthor = gameAuthorRepository.findById(id);
        return gameAuthor.orElse(null);
    }

    @Override
    public List<GameAuthor> getGameAuthors() {
        log.info("Get game authors");
        return gameAuthorRepository.findAll();
    }
}
