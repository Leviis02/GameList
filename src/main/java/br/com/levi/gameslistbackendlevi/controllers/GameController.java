package br.com.levi.gameslistbackendlevi.controllers;

import br.com.levi.gameslistbackendlevi.dtos.GameDTO;
import br.com.levi.gameslistbackendlevi.dtos.GameMinDTO;
import br.com.levi.gameslistbackendlevi.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping (value = "/games")
public class GameController {
    @Autowired
    GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

    // TODO Verificar porque não esta trazendo os dados
    @GetMapping (value = "/{id}")
    public GameMinDTO findById (@PathVariable Long id) {
        GameMinDTO result = gameService.findById(id);
        return result;
    }


}

