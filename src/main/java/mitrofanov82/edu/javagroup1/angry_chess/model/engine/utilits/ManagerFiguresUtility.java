package mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

//Class done and ready to use.

/**
 * Manager figures on the board. <br>
 * - gives the initial arrangement of figures. <br>
 * - moves figures on the board. <br>
 * 
 * @author Ilya Zhukov, Maksim Kosmachev
 */
public class ManagerFiguresUtility {

    /**
     * //TODO add doc-comment ManagerFiguresUtility.makeMove()
     * 
     * @param game
     * @param from
     * @param to
     * @return
     * @throws IncorrectMoveException
     */
    public static GameData makeMove(GameData game, Coord from, Coord to) throws IncorrectMoveException {
        FigureType[][] board = game.getCurrentPosition();

        FigureType fromPosition = board[from.getRow()][from.getCol()];
        board[to.getRow()][to.getCol()] = fromPosition;
        board[from.getRow()][from.getCol()] = null;

        game.setCurrentPosition(board);
        game.addRecordToHistoryLog("Move:" + from + " >>> " + to);

        return game;
    }

    public static FigureType[][] getStartPositions() {
        FigureType[][] startPositions = {
                { FigureType.WHITE_ROOK, FigureType.WHITE_KNIGHT, FigureType.WHITE_BISHOP, FigureType.WHITE_QUEEN,
                  FigureType.WHITE_KING, FigureType.WHITE_BISHOP, FigureType.WHITE_KNIGHT, FigureType.WHITE_ROOK },
                
                { FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN,
                  FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN },
                
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                { null, null, null, null, null, null, null, null }, { null, null, null, null, null, null, null, null },
                
                { FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN,
                  FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN },
                
                { FigureType.BLACK_ROOK, FigureType.BLACK_KNIGHT, FigureType.BLACK_BISHOP, FigureType.BLACK_QUEEN,
                  FigureType.BLACK_KING, FigureType.BLACK_BISHOP, FigureType.BLACK_KNIGHT, FigureType.BLACK_ROOK }
                };
        return startPositions;
    }
}
