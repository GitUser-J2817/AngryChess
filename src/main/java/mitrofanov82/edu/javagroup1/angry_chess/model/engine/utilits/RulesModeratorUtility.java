package mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;

/**
 * Moderator Rules - checks the moves for compliance with the rules and logic of
 * the game. <br>
 * 
 * @author Ilya Zhukov
 *
 */
public class RulesModeratorUtility {

	public static boolean chekMove(FigureType[][] tempCurrentPosition, Coord from, Coord to) {
		
		if (RulesModeratorTest.chekMove(tempCurrentPosition, from, to)) {
			// For tests
			return true;
		}

		// TODO Create method chekMove() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMovePawn() {
		// TODO Create method chekMovePawn() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMoveRook() {
		// TODO Create method chekMoveRook() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMoveKnight() {
		// TODO Create method chekMoveKnight() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMoveBishop() {
		// TODO Create method chekMoveBishop() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMoveQueen() {
		// TODO Create method chekMoveQueen() in the class RulesModeratorUtility
		return false;
	}

	private static boolean checkMoveKing() {
		// TODO Create method chekMoveKing() in the class RulesModeratorUtility
		return false;
	}

}
