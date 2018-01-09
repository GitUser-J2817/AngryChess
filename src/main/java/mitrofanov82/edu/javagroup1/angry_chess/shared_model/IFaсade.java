package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface IFaсade {

	IGame createNewGame();
	IGame getCurentGame(long gameId);
	IGame endCurrentGame(GameResultType status);
	GameResultType getGameStatus(long gameId);
	
	List<IPlayer>getAllRegisteredPlayers();
	List<IGame>getGameHistory(IPlayer p1, IPlayer p2);
	List<IGame>getGameHistory();
	List<IGame>getGameHistory(IPlayer p);
	
	//сделать ход и прочее по одной игре команды
}
