package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.ArrayList;

public interface IGame {
	//to do
	long getGameId();

	GameStatusType getGameStatus();

	FigureType[][] getCurrentPosition();

	IPlayer getPlayerToMove();

	IPlayer getWhitePlayer();

	IPlayer getBlackPlayer();

	ArrayList<String> getHistoryLog();

	default boolean isFinished() {
		return getPlayerToMove() == null;
	};

}
