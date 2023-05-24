package br.com.levi.gameslistbackendlevi.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

@Entity
public class GameList {
    @Id
    private Long id;
    private String name;

    public GameList(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GameList gameList = (GameList) o;
        return Objects.equals(id, gameList.id) && Objects.equals(name, gameList.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
