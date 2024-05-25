package com.example.prac15;

import com.example.prac15.models.Game;
import jakarta.annotation.PostConstruct;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameRepository {

    @Autowired
    private SessionFactory sessionFactory;

    private Session session;

    @PostConstruct
    void init() {
        session = sessionFactory.openSession();
    }

    public void addGame(Game game) {
        session.beginTransaction();
        session.persist(game);
        session.flush();
        session.getTransaction().commit();
    }

    public void removeGameByName(String name) {
        String hql = "delete Game where name=:name";
        session.createQuery(hql, Game.class).setParameter("name", name);
    }

    public List<Game> getGames() {
        return session.createQuery("from Game", Game.class).getResultList();
    }
}
