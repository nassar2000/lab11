package com.example.demo.controller;

import com.example.demo.Game.Game;
import com.example.demo.model.GameEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

@RestController
public class ControllerGame {


    @GetMapping("/dateGame")
    public String getGames() throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Game");
        Game game=new Game(emf);
        return game.list().toString();


    }

    @PostMapping(value = "/addGame")
    public GameEntity addGames( GameEntity newGame) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Game");
        Game game=new Game(emf);
        game.create(newGame);
        return newGame;
    }

    @PutMapping(value = "/modifyGame")
    public void modifyGames(String name, String nameModified) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Game");
        Game game=new Game(emf);
        game.modify(name,nameModified);

    }

    @DeleteMapping(value = "/deleteGame")
    public void deleteGames(String name) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Game");
        Game game=new Game(emf);
        game.delete(name);
    }

}