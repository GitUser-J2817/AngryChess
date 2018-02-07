package mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

/*
 * Class done and ready to use.
 */

/**
 * Class for Data Transfer Object a <b>Game</b>, implement the interface
 * <b>IGame</b> <br>
 * <b>Used only for model!</b>
 * 
 * @author Ilya Zhukov
 */
public class GameData implements IGame {
	// Fields
	private IPlayer whitePlayer;
	private IPlayer blackPlayer;
	private IPlayer playerToMove;
	private ArrayList<String> historyLog;
	private FigureType[][] currentPosition;
	private GameStatusType gameStatus;
	private long id;

	// Constructors
	/**
	 * Constructor of the DTO <b>Game</b>.
	 * 
	 * @param id
	 *            - unique game identification number.
	 * @param whitePlayer
	 *            - Data of player, who play of white figures.
	 * @param blackPlayer
	 *            - Data of player, who play of black figures.
	 */
	public GameData(long id, IPlayer whitePlayer, IPlayer blackPlayer) {
		this.id = id;
		this.whitePlayer = whitePlayer;
		this.blackPlayer = blackPlayer;
		this.playerToMove = whitePlayer;
		this.gameStatus = GameStatusType.IN_PROGRESS;
		this.currentPosition = ManagerFiguresUtility.getStartPositions();
	}

	// Setters
	public void setGameStatus(GameStatusType gameStatus) {
		this.gameStatus = gameStatus;
	}

	public void setPlayerToMove(IPlayer playerToMove) {
		this.playerToMove = playerToMove;
	}

	public void setCurrentPosition(FigureType[][] currentPosition) {
		this.currentPosition = currentPosition;
	}

	/**
	 * Каждое новое добавляемое значение будет первым в списке с идексом 0.
	 * 
	 * @param lastMove
	 *            - строковое обозначение последнего хода в виде (e2 – e4).
	 */
	public void addRecordToHistoryLog(String lastMove) {
		ArrayList<String> tempArrayStrings = new ArrayList<>();
		tempArrayStrings.add(lastMove);
		tempArrayStrings.addAll(historyLog);
		this.historyLog = tempArrayStrings;
		tempArrayStrings = null;
	}

	// Getters
	public IPlayer getWhitePlayer() {
		return whitePlayer;
	}

	public IPlayer getBlackPlayer() {
		return blackPlayer;
	}

	public IPlayer getPlayerToMove() {
		return playerToMove;
	}

	public ArrayList<String> getHistoryLog() {
		return historyLog;
	}

	public FigureType[][] getCurrentPosition() {
		return currentPosition;
	}

	public long getGameId() {
		return id;
	}

	public GameStatusType getGameStatus() {
		return gameStatus;
	}

}