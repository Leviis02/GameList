package br.com.levi.gameslistbackendlevi.repositories;

import br.com.levi.gameslistbackendlevi.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository <GameList, Long> {


}
