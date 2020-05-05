package com.example.demo.Player;

import com.example.demo.model.PlayerEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class Player {

    private EntityManagerFactory entityManagerFactory;

    public Player(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    /**/
    public void create(PlayerEntity player) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(player);

        entityManager.getTransaction().commit();

        entityManager.close();

    }

    public String list() {


        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Query query = entityManager.createQuery("select g from PlayerEntity g ");

        List<PlayerEntity> plyers = query.getResultList();
        entityManager.close();
        return plyers.toString();
    }
    public void modify(String name,String nameModified){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("update PlayerEntity g set g.playerName =:playerChange2  where g.playerName = :playerChange");
        query.setParameter("playerChange", name);
        query.setParameter("playerChange2", nameModified);
        query.executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    public void delete(String name){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery(
                "DELETE FROM PlayerEntity g WHERE g.playerName = :p ");
        query.setParameter("p", name).executeUpdate();
        entityManager.getTransaction().commit();
        entityManager.close();

    }

}