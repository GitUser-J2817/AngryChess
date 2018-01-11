package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class ModelFacade implements IGame {

	public IPlayer getWhitePlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public IPlayer getBlackPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public ChessBoard getBoard() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> getHistoryLog() {
		// TODO Auto-generated method stub
		return null;
	}
	//all method that are required for any UI.

	public FigureType getFigureType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IPlayer getPlayerToMove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FigureType[][] getCurrentPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getGameId() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GameStatusType getGameStatus() {
		// TODO Auto-generated method stub
		return null;
	}
	
}