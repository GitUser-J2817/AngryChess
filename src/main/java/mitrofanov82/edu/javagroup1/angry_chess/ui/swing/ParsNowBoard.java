package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessBoard;
import mitrofanov82.edu.javagroup1.angry_chess.model.ModelFacade;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ParsNowBoard extends JPanel {
    //private JPanel ChessBoard = new JPanel();
    private BufferedImage image = null;

    ParsNowBoard() {
        setBounds(58, 49, 500, 500);
        setMinimumSize(new Dimension(500, 500));
        setLayout(new GridLayout(8, 8));
        setOpaque(false);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                this.add(new JLabel(new ImageIcon(getPathFigures(i, j, getStartPositions()))));

            }
        }
    }


    private BufferedImage getPathFigures(int a, int b, FigureType[][] game) {
        String Path = "./src/main/resources/figures/";
        FigureType figure[][] = game;
        if (figure[a][b].equals(FigureType.BLACK_PAWN)) {
            Path += "BLACK_PAWN.png";
        } else if (figure[a][b].equals(FigureType.BLACK_BISHOP)) {
            Path += "BLACK_BISHOP.png";
        } else if (figure[a][b].equals(FigureType.BLACK_KNIGHT)) {
            Path += "BLACK_KNIGHT.png";
        } else if (figure[a][b].equals(FigureType.BLACK_ROOK)) {
            Path += "BLACK_ROOK.png";
        } else if (figure[a][b].equals(FigureType.BLACK_KING)) {
            Path += "BLACK_KING.png";
        } else if (figure[a][b].equals(FigureType.BLACK_QUEEN)) {
            Path += "BLACK_QUEEN.png";
        } else if (figure[a][b].equals(FigureType.WHITE_PAWN)) {
            Path += "WHITE_PAWN.png";
        } else if (figure[a][b].equals(FigureType.WHITE_BISHOP)) {
            Path += "WHITE_BISHOP.png";
        } else if (figure[a][b].equals(FigureType.WHITE_KNIGHT)) {
            Path += "WHITE_KNIGHT.png";
        } else if (figure[a][b].equals(FigureType.WHITE_ROOK)) {
            Path += "WHITE_ROOK.png";
        } else if (figure[a][b].equals(FigureType.WHITE_KING)) {
            Path += "WHITE_KING.png";
        } else if (figure[a][b].equals(FigureType.WHITE_QUEEN)) {
            Path += "WHITE_QUEEN.png";
        } else if (figure[a][b].equals(FigureType.NULL)){
            Path += "NULL.png";
        }
        try {
            image = ImageIO.read(new File(Path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static FigureType[][] getStartPositions() {
        FigureType[][] startPositions =
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
        return startPositions;
    }


}

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