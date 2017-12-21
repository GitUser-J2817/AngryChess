package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

public interface IGame {
	
	default boolean isFinished() {
		return getPlayerToMove() == null;
	};
	
	IPlayer getPlayerToMove(); //(null if finished)
	GameResultType getGameResult(); //ENUM: WHITE_WIN, B_WIN, DRAW, NOT_FINISHED
	FigureType[][] getCurrentPosition();
	IPlayer getWhitePlayer();
	IPlayer getBlackPlayer();
	String getHistoryLog();
	
}
