package mitrofanov82.edu.javagroup1.angry_chess.model;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

/**
 * Interface describing the management model Angry Chess.
 */
public interface IFaсade {
	/**
	 * The method creates a new game based on the passed parameters. Then it returns
	 * an object with the current state of the game.
	 * 
	 * 
	 * @param gameId
	 *            - It takes the value of the <b>ID</b>(<i>long</i>) of the created
	 *            game. Can throw <b>IdentifierGameException</b> extensible
	 *            <b>ChessModelException</b> if the transmitted <b>ID</b> already
	 *            exists.
	 * @param p1
	 *            - First player, who plays white figures.
	 * @param p2
	 *            - Second player, who plays black figures.
	 * @return - Returns the object, implement <b>IGame</b>, with the current state
	 *         of the created game.
	 * @throws -
	 *             ChessModelException - General model error or error of bad
	 *             parameters.
	 */
	IGame createNewGame(long gameId, IPlayer whitePlayer, IPlayer blackPlayer) throws ChessModelException;

	/**
	 * The method moves the figure to the given coordinates. If coordinates or the
	 * possibility of a move, according to the rules, is wrong, throws an exception
	 * <b>IncorrectMoveExceptionon</b.
	 * 
	 * @param game
	 *            - The object with the current state of the game.
	 * @param from
	 *            - The DTO coordinates where the figure comes from.
	 * @param to
	 *            - The DTO coordinates where the figure moves.
	 * @return - Returns the object, implement <b>IGame</b>, with the current state,
	 *         after make move. If the move is correct, otherwise throws
	 *         <b>IncorrectMoveExceptionon</b>.
	 * @throws IncorrectMoveException
	 *             - If the passed move is not possible by the rules, then an
	 *             exception is thrown.
	 */
	IGame makeMove(IGame game, Coord from, Coord to) throws IncorrectMoveException;

	/**
	 * The method returns the object with the current state of the requested game by
	 * <b>ID</b>. If there is no game with such ID, then returned is <b>null</b>.
	 * 
	 * @param gameId
	 *            - ID of the requested game.
	 * @return - The object, implement <b>IGame</b>, with the current state of the
	 *         requested game.
	 */
	IGame getGameById(long gameId);

	/**
	 * The method completes the game with the received status, and the return of the
	 * DTO of the final game.
	 * 
	 * @param game
	 *            - The object, implement <b>IGame</b>, with the current state the
	 *            game.
	 * @param status
	 *            - The type of game state to complete. The statuses are listed in
	 *            <i>enum</i> <b>GameStatusType</b>.
	 * @return - The object, implement <b>IGame</b>, with the final state of the
	 *         requested game.
	 */
	IGame endGame(IGame game, GameStatusType status);

	/**
	 * The method return the current state of the requested game by <b>ID</b>.
	 * 
	 * @param gameId
	 *            - <b>ID</b> requested game.
	 * @return - Status requested game. The statuses are listed in <i>enum</i>
	 *         <b>GameStatusType</b>.
	 * @throws ChessModelException
	 *             - If such a game does not exist, then an thrown exception
	 *             <b>ChessModelException</b>.
	 */
	GameStatusType getGameStatus(long gameId) throws ChessModelException;

	/**
	 * The method returns a list of current games, in the form of a <b>List</b> of
	 * objects, that implement <b>IGame</b>.
	 * 
	 * @return - <b>List</b> of objects, that implement <b>IGame</b>.
	 */
	List<IGame> getCurrentGames();
}