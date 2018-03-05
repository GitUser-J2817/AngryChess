package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

/**
 *  The interface describes the management of the saving and reading of the history of games
 */
public interface IChessPersistenceAPI {

    /**
     * Saves the current state of the game
     *  
     * @param game - the object with the current state of the game
     */
    void saveGameResults(IGame game);

    /**
     * Returns history of all games
     * 
     * @return List of <b>IGameHistory</b>
     */
    List<IGameHistory> getGamesHistory();

    /**
     * Returns history of games with some player
     * 
     * @param p - player with whose participation it is necessary to return the list of saved games
     * @return List of <b>IGameHistory</b>
     */
    List<IGameHistory> getGamesHistory(IPlayer p);

    /**
     * Returns history of games between two players
     * 
     * @param p1 - first player with whose participation it is necessary to return the list of saved games
     * @param p2 - second player with whose participation it is necessary to return the list of saved games
     * @return List of <b>IGameHistory</b>
     */
    List<IGameHistory> getGamesHistory(IPlayer p1, IPlayer p2);

    /**
     * Returns list of all registered players
     * 
     * @return List of <b>IPlayer</b>
     */
    List<IPlayer> getAllRegisteredPlayers();
}
