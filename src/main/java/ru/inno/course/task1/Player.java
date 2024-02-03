package ru.inno.course.task1;

import java.util.Objects;

public class Player {
    private int id;
    private String nickName;
    private boolean isOnline;

    public Player(int id, String nickName, boolean isOnline) {
        this.id = id;
        this.nickName = nickName;
        this.isOnline = isOnline;
    }

    public int getId() {
        return id;
    }
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return getId() == player.getId() && isOnline() == player.isOnline() && Objects.equals(getNickName(), player.getNickName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getNickName(), isOnline());
    }

    @Override
    public String toString() {
        return "Игрок: " + nickName+
                " id = " + id;
    }
}
