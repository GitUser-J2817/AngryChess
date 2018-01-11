package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface IFaсade {

	IGame createNewGame(long gameId, IPlayer p1, IPlayer p2); //кто создаёт ID игры и нужно ли все команды индифицировать по ID?
	IGame makeMove(IGame game, Coord from, Coord to);//придумать как передовать кординаты
	IGame getGameById(long gameId);
	IGame endGame(IGame game, GameStatusType status);
	GameStatusType getGameStatus(long gameId);
	List<IGame> getCurrentGames();
	
	//перенести в фасад персистенс-модуля
	List<IGame> getGamesHistory();
	List<IGame>getGamesHistory(IPlayer p);
	List<IGame>getGamesHistory(IPlayer p1, IPlayer p2);
	List<IPlayer> getAllRegisteredPlayers();
	
	
}
















