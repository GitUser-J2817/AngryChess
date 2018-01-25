package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

public class SimpleModel implements IFaсade {

	private Model model;
	
	@Override
	public IGame createNewGame(long gameId, IPlayer p1, IPlayer p2) throws ChessModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame getGameById(long gameId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGame endGame(IGame game, GameStatusType status) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameStatusType getGameStatus(long gameId) throws ChessModelException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IGame> getCurrentGames() {
		// TODO Auto-generated method stub
		return null;
	}

}
