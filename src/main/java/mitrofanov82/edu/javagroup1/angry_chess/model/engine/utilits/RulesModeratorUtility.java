package mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;

/**
 * Moderator Rules - checks the moves for compliance with the rules and logic of
 * the game. <br>
 * 
 * @author Ilya Zhukov, Maksim Kosmachev
 */
public class RulesModeratorUtility {

    /**
     * //TODO add doc-comment RulesModeratorUtility.checkMove();
     * 
     * @param currentGame
     * @param from
     * @param to
     * @return
     */
    public static boolean checkMove(GameData currentGame, Coord from, Coord to) {

        boolean testON = true; // FIXME for tests
        if (!testON) {
            if (!checkAdequacy(currentGame, from, to)) {
                return false;
            }

            if (!checkPiece(currentGame, from, to)) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkAdequacy(GameData currentGame, Coord from, Coord to) {
        // FigureType[][] board = currentGame.getCurrentPosition();
        // FigureType stepFrom = board[from.getRow()][from.getCol()];
        // FigureType stepTo = board[to.getRow()][to.getCol()];
        // if(stepTo=null || stepFrom.)

        // TODO Create method checkLogic() in the class RulesModeratorUtility
        // from piece != null
        // "from" and "to" a pieces is not one color
        // "from" is figure current Player
        // Coordinates from = 0...7 and to = 0...7
        return false;
    }

    private static boolean checkPiece(GameData currentGame, Coord from, Coord to) {
        FigureType[][] blackboard = currentGame.getCurrentPosition();
        FigureType curentPiece = blackboard[from.getRow()][from.getCol()];

        if (curentPiece == FigureType.BLACK_PAWN || curentPiece == FigureType.WHITE_PAWN) {
            return checkMovePawn();
        }
        if (curentPiece == FigureType.BLACK_ROOK || curentPiece == FigureType.WHITE_ROOK) {
            return checkMoveRook();
        }
        if (curentPiece == FigureType.BLACK_KNIGHT || curentPiece == FigureType.WHITE_KNIGHT) {
            return checkMoveKnight();
        }
        if (curentPiece == FigureType.BLACK_BISHOP || curentPiece == FigureType.WHITE_BISHOP) {
            return checkMoveBishop();
        }
        if (curentPiece == FigureType.BLACK_QUEEN || curentPiece == FigureType.WHITE_QUEEN) {
            return checkMoveQueen();
        }
        if (curentPiece == FigureType.BLACK_KING || curentPiece == FigureType.WHITE_KING) {
            return checkMoveKing();
        }
        return false;
    }

    private static boolean checkMovePawn() {
        // TODO Create method checkMovePawn() in the class RulesModeratorUtility
        return false;
    }

    private static boolean checkMoveRook() {
        // TODO Create method checkMoveRook() in the class RulesModeratorUtility
        return false;
    }

    private static boolean checkMoveKnight() {
        // TODO Create method checkMoveKnight() in the class RulesModeratorUtility
        return false;
    }

    private static boolean checkMoveBishop() {
        // TODO Create method checkMoveBishop() in the class RulesModeratorUtility
        return false;
    }

    private static boolean checkMoveQueen() {
        // TODO Create method checkMoveQueen() in the class RulesModeratorUtility
        return false;
    }

    private static boolean checkMoveKing() {
        // TODO Create method checkMoveKing() in the class RulesModeratorUtility
        return false;
    }
}
