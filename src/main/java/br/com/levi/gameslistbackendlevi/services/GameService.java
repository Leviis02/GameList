package br.com.levi.gameslistbackendlevi.services;


import br.com.levi.gameslistbackendlevi.dtos.GameMinDTO;
import br.com.levi.gameslistbackendlevi.entities.Game;
import br.com.levi.gameslistbackendlevi.projections.GameMinProjection;
import br.com.levi.gameslistbackendlevi.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameService {
    @Autowired
    GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        List<Game> result = gameRepository.findAll();
        return result.stream().map(GameMinDTO::new).toList();
    }

    @Transactional(readOnly = true)
    public GameMinDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameMinDTO(result);
    }

    @Transactional(readOnly = true)
    public List<GameMinProjection> findGames(@PathVariable Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        return result;
    }
}

