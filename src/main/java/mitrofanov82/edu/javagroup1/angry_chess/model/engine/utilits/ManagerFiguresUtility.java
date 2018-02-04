package mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;

/**
 * Manager figures on the board. <br>
 * - gives the initial arrangement of figures. <br>
 * - moves figures on the board. <br>
 * @author Ilya Zhukov
 *
 */
public class ManagerFiguresUtility {
	
	public static void makeMove(GameData tempGame, Coord from, Coord to) {
		//TODO Create method makeMove() in the class ManagerFiguresUtility;
	}
	
	public static FigureType[][] getStartPositions() {
		FigureType[][] startPositions = 	
			{
			 {FigureType.WHITE_ROOK,FigureType.WHITE_KNIGHT,FigureType.WHITE_BISHOP,FigureType.WHITE_QUEEN,FigureType.WHITE_KING,FigureType.WHITE_BISHOP,FigureType.WHITE_KNIGHT,FigureType.WHITE_ROOK},
			 {FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN},
			 {null,null,null,null,null,null,null,null},
			 {null,null,null,null,null,null,null,null},
			 {null,null,null,null,null,null,null,null},
			 {null,null,null,null,null,null,null,null},
			 {FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN},
			 {FigureType.BLACK_ROOK,FigureType.BLACK_KNIGHT,FigureType.BLACK_BISHOP,FigureType.BLACK_QUEEN,FigureType.BLACK_KING, FigureType.BLACK_BISHOP, FigureType.BLACK_KNIGHT, FigureType.BLACK_ROOK}
			};
		return startPositions;
	}
}
