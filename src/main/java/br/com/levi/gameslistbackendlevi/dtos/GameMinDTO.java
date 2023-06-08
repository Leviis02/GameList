package br.com.levi.gameslistbackendlevi.dtos;

import br.com.levi.gameslistbackendlevi.entities.Game;

public class GameMinDTO {
    private Long id;
    private String title;
    private Integer game_year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO (Game game){
        id = game.getId();
        title = game.getTitle();
        game_year = game.getYear();
        imgUrl = game.getImgUrl();
        shortDescription = game.getShortDescription();

    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return game_year;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }
}
