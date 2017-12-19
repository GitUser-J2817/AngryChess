package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

public interface Game {
	//перечислить все методы, которые нужны UI от модели
	
	Player getWhitePlayer();
	Player getBlackPlayer();
	ChessBoard getBoard();
	String getHistoryLog();
}
