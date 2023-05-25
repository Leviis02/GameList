package br.com.levi.gameslistbackendlevi.entities;

import jakarta.persistence.EmbeddedId;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Table (name = "tb_belonging")
@Entity

public class Belonging {

    @EmbeddedId
    private BelongingPK id = new BelongingPK ();

    private Integer position;

    public Belonging(Game game, GameList list, Integer position) {
        this.id.setGame(game);
        this.id.setList(list);
        this.position = position;
    }

    public BelongingPK getId() {
        return id;
    }

    public void setId(BelongingPK id) {
        this.id = id;
    }

    public Integer getPosition() {
        return position;
    }

    public void setPosition(Integer position) {
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Belonging belonging = (Belonging) o;
        return Objects.equals(id, belonging.id) && Objects.equals(position, belonging.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, position);
    }
}
