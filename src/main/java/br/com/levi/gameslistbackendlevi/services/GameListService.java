package br.com.levi.gameslistbackendlevi.services;

import br.com.levi.gameslistbackendlevi.dtos.GameListDTO;
import br.com.levi.gameslistbackendlevi.entities.Game;
import br.com.levi.gameslistbackendlevi.entities.GameList;
import br.com.levi.gameslistbackendlevi.repositories.GameListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll (){
        List <GameList> gameList = gameListRepository.findAll();
        return gameList.stream().map(GameListDTO::new).toList();
    }
    @Transactional(readOnly = true)
    public GameListDTO findById(@PathVariable Long id){
        GameList gameList = gameListRepository.findById(id).get();
        return new GameListDTO(gameList);
    }

}
