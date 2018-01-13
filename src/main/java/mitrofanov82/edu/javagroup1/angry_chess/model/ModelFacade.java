package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class ModelFacade implements IGame {

	public IPlayer getWhitePlayer() {
		// TODO getWhitePlayer()
		return null;
	}

	public IPlayer getBlackPlayer() {
		// TODO getBlackPlayer()
		return null;
	}

	public ChessBoard getBoard() {
		// TODO getBoard()
		return null;
	}

	public ArrayList<String> getHistoryLog() {
		// TODO getHistoryLog()
		return null;
	}

	public FigureType getFigureType() {
		// TODO getFigureType()
		return null;
	}

	@Override
	public IPlayer getPlayerToMove() {
		// TODO getPlayerToMove()
		return null;
	}

	@Override
	public FigureType[][] getCurrentPosition() {
		// TODO getCurrentPosition()
		return null;
	}

	@Override
	public long getGameId() {
		// TODO getGameId()
		return 0;
	}

	@Override
	public GameStatusType getGameStatus() {
		// TODO getGameStatus()
		return null;
	}
	
}