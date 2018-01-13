package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

class Game implements IGame {
	// Fields
	// --player--
	IPlayer whitePlayer;
	IPlayer blackPlayer;
	IPlayer playerToMove;
	// --history--
	ArrayList<String> historyLog;
	// --game data--
	FigureType[][] chessBoard;
	GameStatusType gameStatus;
	long id;

	// Constructors
	Game() {
		// TODO 1.1 Constructors
		// TODO 1.2 chessBoard - начальная растановка сдеся;
	}

	// Getters
	public IPlayer getWhitePlayer() {
		return whitePlayer;
	}

	public IPlayer getBlackPlayer() {
		return blackPlayer;
	}

	public IPlayer getPlayerToMove() {
		// TODO getPlayerToMove()
		return null;
	}

	public ArrayList<String> getHistoryLog() {
		// TODO getHistoryLog()
		return null;
	}

	public FigureType[][] getCurrentPosition() {
		// TODO getCurrentPosition()
		return null;
	}

	public long getGameId() {
		// TODO getGameId()
		return 0;
	}

	public GameStatusType getGameStatus() {
		// TODO getGameStatus()
		return null;
	}

	// Setters

	/**
	 * Каждое новое добавляемое значение будет первым в списке с идексом 0.
	 * 
	 * @param lastMove
	 *            - строковое обозначение последнего хода в виде (e2 – e4).
	 */
	void setRecordHistoryLog(String lastMove) {
		ArrayList<String> tempArrayStrings = new ArrayList<>();
		tempArrayStrings.add(lastMove);
		tempArrayStrings.addAll(historyLog);
		this.historyLog = tempArrayStrings;
		tempArrayStrings = null;
	}

	void setGameStatus(GameStatusType gameStatus) {
		this.gameStatus = gameStatus;
	}

}