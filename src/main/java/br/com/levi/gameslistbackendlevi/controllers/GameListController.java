package br.com.levi.gameslistbackendlevi.controllers;

import br.com.levi.gameslistbackendlevi.dtos.GameListDTO;
import br.com.levi.gameslistbackendlevi.dtos.GameMinDTO;
import br.com.levi.gameslistbackendlevi.projections.GameMinProjection;
import br.com.levi.gameslistbackendlevi.services.GameListService;
import br.com.levi.gameslistbackendlevi.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping (value = "/gamelist")
public class GameListController {
    @Autowired
    GameListService gameListService;

    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll(){
        return gameListService.findAll();
    }

    @GetMapping (value = "/{id}")
    public GameListDTO findById(@PathVariable Long id){
        return gameListService.findById(id);
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinProjection> findGamesByListId(@PathVariable Long listId) {
        List<GameMinProjection> result = gameService.findGames(listId);
        return result;
    }
    }

