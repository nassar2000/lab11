package com.example.demo.controller;

import com.example.demo.Player.Player;
import com.example.demo.model.PlayerEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;

@RestController
public class ControllerPlayer {


    @GetMapping("/datePlayer")
    public String getPlayer() throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Player");
        Player player=new Player(emf);
        return player.list().toString();


    }

    @PostMapping(value = "/addPlayer")
    public PlayerEntity addPlayer( PlayerEntity newPlayer) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Player");
        Player player=new Player(emf);
        player.create(newPlayer);
        return newPlayer;
    }

    @PutMapping(value = "/modifyPlayer")
    public void modifyPlayer(String name, String nameModified) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Player");
        Player player=new Player(emf);
        player.modify(name,nameModified);

    }

    @DeleteMapping(value = "/deletePlayer")
    public void deletePlayer(String name) throws SQLException {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("Player");
        Player player=new Player(emf);
        player.delete(name);
    }

}