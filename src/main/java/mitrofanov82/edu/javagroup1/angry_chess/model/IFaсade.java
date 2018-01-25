package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

public interface IFaсade {

	IGame createNewGame(long gameId, IPlayer p1, IPlayer p2) throws ChessModelException ;

	IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException;

	IGame getGameById(long gameId);//если нет ID возвращает null;

	IGame endGame(IGame game, GameStatusType status);

	GameStatusType getGameStatus(long gameId)throws ChessModelException;

	List<IGame> getCurrentGames();
}