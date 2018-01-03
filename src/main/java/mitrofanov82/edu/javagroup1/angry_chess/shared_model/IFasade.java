package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface IFasade {

	IGame createNewGame();
	IGame getCurentGame();
	IGame endCurrentGame(GameResultType status);
	GameResultType getStatusGame();//?
	
	List<IPlayer>getAllRegisteredPalaers();
	List<IGame>getHistoryGames(IPlayer p1, IPlayer p2);
	
	
}
