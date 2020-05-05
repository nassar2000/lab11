package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Game", schema = "dbo", catalog = "Games")
public class GameEntity {
    private int roomId;
    private String roomName;


    @Id
    @Column(name = "roomId")
    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    @Basic
    @Column(name = "roomName")
    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameEntity that = (GameEntity) o;
        return
                roomId == that.roomId &&
                Objects.equals(roomName, that.roomName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roomId, roomName);
    }

    @Override
    public String toString() {
        return "GameEntity{" +
                "roomId=" + roomId +
                ", roomName='" + roomName + '\'' +
                '}';
    }
}