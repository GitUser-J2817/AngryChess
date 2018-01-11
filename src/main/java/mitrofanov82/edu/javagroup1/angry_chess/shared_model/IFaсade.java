package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface IFaсade {

	IGame createNewGame(); //кто создаёт ID игры и нужно ли все команды индифицировать по ID?
	IGame makeMove();//придумать как передовать кординаты
	IGame getCurentGame(long gameId);
	IGame endCurrentGame(GameStatusType status);
	
	GameStatusType getGameStatus(long gameId);
	
	List<IPlayer>getAllRegisteredPlayers();
	
	List<IGame>getGameHistory();
	List<IGame>getGameHistory(IPlayer p);
	List<IGame>getGameHistory(IPlayer p1, IPlayer p2);
	
}
