package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;

import mitrofanov82.edu.javagroup1.angry_chess.model.engine.EngineTheFirst;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IdentifierGameException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

/*
 * Class done and ready to use.
 */
/**
 * The class that implements the Angry Chess model management. <br>
 * (current model engine - "The First")
 * 
 * @author Ilya Zhukov
 *
 */
public class SimpleChessModel implements IFaсade {
	private EngineTheFirst model;

	public SimpleChessModel() {
		this.model = new EngineTheFirst();
	}
	
	@Override
	public IGame createNewGame(long gameId, IPlayer p1, IPlayer p2) throws IdentifierGameException {
		return model.createNewGame(gameId, p1, p2);
	}

	@Override
	public IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException {
		return model.makeMove(game, from, to);
	}

	@Override
	public IGame getGameById(long gameId) {
		return model.getGameById(gameId);
	}

	public IGame endGame(IGame game, GameStatusType status) {
		return model.endGame(game, status);
	}
	
	@Override
	public GameStatusType getGameStatus(long gameId) throws ChessModelException {
		return model.getGameStatus(gameId);
	}

	@Override
	public List<IGame> getCurrentGames() {
		return model.getCurrentGames();
	}

}
