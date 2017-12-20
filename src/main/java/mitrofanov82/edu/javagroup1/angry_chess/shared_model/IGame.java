package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

public interface IGame {
	
	FigureType getFigureType();
	IPlayer getWhitePlayer();
	IPlayer getBlackPlayer();
	ChessBoard getBoard();
	String getHistoryLog();
	
}
