package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import javax.swing.*;
import java.awt.*;

public class ParsNowBoard extends JPanel {

    ParsNowBoard() {
        setBounds(58, 49, 500, 500);
        setMinimumSize(new Dimension(500, 500));
        setLayout(new GridLayout(8, 8));
        setOpaque(false);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.add(new JLabel(new ImageIcon(ImagesUtils.getPathFigures(i, j, getStartPositions()))));
            }
        }
    }

    /*
    This Method befor merge in develop - delete
     */
    public static FigureType[][] getStartPositions() {
        FigureType[][] startPositions = {
                { FigureType.WHITE_ROOK, FigureType.WHITE_KNIGHT, FigureType.WHITE_BISHOP, FigureType.WHITE_QUEEN,
                        FigureType.WHITE_KING, FigureType.WHITE_BISHOP, FigureType.WHITE_KNIGHT,
                        FigureType.WHITE_ROOK },
                { FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN,
                        FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN, FigureType.WHITE_PAWN },
                { FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL,
                        FigureType.NULL, FigureType.NULL },
                { FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL,
                        FigureType.NULL, FigureType.NULL },
                { FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL,
                        FigureType.NULL, FigureType.NULL },
                { FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL, FigureType.NULL,
                        FigureType.NULL, FigureType.NULL },
                { FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN,
                        FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN, FigureType.BLACK_PAWN },
                { FigureType.BLACK_ROOK, FigureType.BLACK_KNIGHT, FigureType.BLACK_BISHOP, FigureType.BLACK_QUEEN,
                        FigureType.BLACK_KING, FigureType.BLACK_BISHOP, FigureType.BLACK_KNIGHT,
                        FigureType.BLACK_ROOK } };
                 /*
                {
                        {FigureType.WHITE_ROOK,FigureType.WHITE_KNIGHT,FigureType.WHITE_BISHOP,FigureType.WHITE_QUEEN,FigureType.WHITE_KING,FigureType.WHITE_BISHOP,FigureType.WHITE_KNIGHT,FigureType.WHITE_ROOK},
                        {FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN,FigureType.WHITE_PAWN},
                        {FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL},
                        {FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL},
                        {FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL},
                        {FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL,FigureType.NULL},
                        {FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN,FigureType.BLACK_PAWN},
                        {FigureType.BLACK_ROOK,FigureType.BLACK_KNIGHT,FigureType.BLACK_BISHOP,FigureType.BLACK_QUEEN,FigureType.BLACK_KING, FigureType.BLACK_BISHOP, FigureType.BLACK_KNIGHT, FigureType.BLACK_ROOK}
                };
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
                */
        return startPositions;
    }

}
