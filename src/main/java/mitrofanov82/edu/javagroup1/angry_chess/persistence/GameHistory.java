package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

/**
 * The class that implements the management of the history of games
 * 
 * @author Alexander Neznaev
 */
public class GameHistory implements IGameHistory {

    private long gameId;
    private GameStatusType status;
    private IPlayer white;
    private IPlayer black;

    /**
     * Create a new GameHistory object
     * 
     * @param gameId - ID of the current saved game as long number
     * @param status - status of the current saved game as <i>enum</i> <b>GameStatusType</b>.
     * @param white - player on Light Side as <code>IPLayer</code>
     * @param black - player on Dark Side as <code>IPLayer</code>
     */
    public GameHistory(long gameId, GameStatusType status, IPlayer white, IPlayer black) {
        this.gameId = gameId;
        this.status = status;
        this.white = white;
        this.black = black;
    }

    public GameHistory(IGame game) {
        gameId = game.getGameId();
        status = game.getGameStatus();
        white = game.getWhitePlayer();
        black = game.getBlackPlayer();
    }

    public long getGameId() {
        return gameId;
    }

    public GameStatusType getGameStatus() {
        return status;
    }

    public IPlayer getWhitePlayer() {
        return white;
    }

    public IPlayer getBlackPlayer() {
        return black;
    }
}
