package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

public interface IGame {
	
	
	long getGameId();
	GameStatusType getGameStatus();
	FigureType[][] getCurrentPosition();
	
	IPlayer getPlayerToMove(); //(null if finished)
	IPlayer getWhitePlayer();
	IPlayer getBlackPlayer();
	
	//Выбрать что-то:
	// String[] getHistoryLog();
	// ArrayList<String> getHistoryLog();
	
	default boolean isFinished() {
		return getPlayerToMove() == null;
	};//После переделки GameStatusType(GameResultType) нужен ли этот метод,
		//или как дополнительный пусть будет?

	
	
}
