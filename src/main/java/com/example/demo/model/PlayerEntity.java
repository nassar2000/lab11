package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Player", schema = "dbo", catalog = "Games")
public class PlayerEntity {
    private int playerId;
    private String playerName;
    private int playerScore;
    private int playerWins;

    @Id
    @Column(name = "playerId")
    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    @Basic
    @Column(name = "playerName")
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Basic
    @Column(name = "playerScore")
    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    @Basic
    @Column(name = "playerWins")
    public int getPlayerWins() {
        return playerWins;
    }

    public void setPlayerWins(int playerWins) {
        this.playerWins = playerWins;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerEntity that = (PlayerEntity) o;
        return
                playerId == that.playerId &&
                playerScore == that.playerScore &&
                playerWins == that.playerWins &&
                Objects.equals(playerName, that.playerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerId, playerName, playerScore, playerWins);
    }

    @Override
    public String toString() {
        return "PlayerEntity{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", playerScore=" + playerScore +
                ", playerWins=" + playerWins +
                '}';
    }
}