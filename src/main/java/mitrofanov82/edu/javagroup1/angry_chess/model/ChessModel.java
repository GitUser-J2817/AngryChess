package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.model.engine.EngineTheFirst;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

// Class done and ready to use.

/**
 * The class that implements the Angry Chess model management. <br>
 * (current model engine - "The First")
 * 
 * @author Ilya Zhukov
 */
public class ChessModel implements ChessModelAPI {
    private EngineTheFirst chessEngine;

    public ChessModel() {
        this.chessEngine = new EngineTheFirst();
    }

    @Override
    public IGame createNewGame(long gameId, IPlayer whitePlayer, IPlayer blackPlayer) throws ChessModelException {
        return chessEngine.createNewGame(gameId, whitePlayer, blackPlayer);
    }

    @Override
    public IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException {
        return chessEngine.makeMove(game, from, to);
    }

    @Override
    public IGame getGameById(long gameId) {
        return chessEngine.getGameById(gameId);
    }

    @Override
    public IGame endGame(IGame game, GameStatusType status) {
        return chessEngine.endGame(game, status);
    }

    @Override
    public GameStatusType getGameStatus(long gameId) throws ChessModelException {
        return chessEngine.getGameStatus(gameId);
    }

    @Override
    public List<IGame> getCurrentGames() {
        return chessEngine.getCurrentGames();
    }

}
