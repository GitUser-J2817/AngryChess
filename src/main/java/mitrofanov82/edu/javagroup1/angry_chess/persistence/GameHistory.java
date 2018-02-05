package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class GameHistory implements IGameHistory {
    
    private long gameId;
    private GameStatusType status;
    private IPlayer white;
    private IPlayer black;
    
    public GameHistory (long gameId, GameStatusType status, IPlayer white, IPlayer black) {
	this.gameId = gameId;
	this.status = status;
	this.white = white;
	this.black = black;
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
