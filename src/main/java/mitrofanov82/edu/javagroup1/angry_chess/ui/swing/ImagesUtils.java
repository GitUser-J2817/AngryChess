package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagesUtils {
    private static BufferedImage image = null;

    public static BufferedImage ImageBufferedIcon(String name) {
        String Path = "./src/main/resources/";
        if (name.equals("backgroundChessBoard.jpg")) {
            Path += "backgroundChessBoard.jpg";
        } else if (name.equals("avatarWhite")) {
            Path += "whitePlayer.png";
        } else if (name.equals("avatarBlack")) {
            Path += "blackPlayer.png";
        } else if (name.equals("angry")) {
            Path += "angry.jpg";
        } else if (name.equals("chess")) {
            Path += "chess.jpg";
        } else if (name.equals("newGame")) {
            Path += "new_game.jpg";
        } else if (name.equals("newGameAction")) {
            Path += "new_game_action.jpg";
        } else if (name.equals("statistic")) {
            Path += "statistic.jpg";
        } else if (name.equals("statisticAction")) {
            Path += "statistic_action.jpg";
        } else if (name.equals("exitGame")) {
            Path += "exit.jpg";
        } else if (name.equals("exitAction")) {
            Path += "exit_action.jpg";
        } else if (name.equals("newGameLogo")) {
            Path += "new_game_logo.jpg";
        } else if (name.equals("backMenu")) {
            Path += "back.jpg";
        } else if (name.equals("backMenuAction")) {
            Path += "back_action.jpg";
        } else if (name.equals("going")) {
            Path += "going.jpg";
        } else if (name.equals("goingAction")) {
            Path += "going_action.jpg";
        } else if (name.equals("avatar")) {
            Path += "blank_avatar.png";
        } else if (name.equals("staticLogo")) {
            Path += "statistic_logo.jpg";
        } else if (name.equals("backButton")) {
            Path += "back.jpg";
        } else if (name.equals("backActionButton")) {
            Path += "back_action.jpg";
        }
        try {
            image = ImageIO.read(new File(Path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static BufferedImage getPathFigures(int a, int b, FigureType[][] figures) {
        String Path = "./src/main/resources/figures/";
        if (figures[a][b] == null) {
            Path += "NULL.png";
        }
        if (figures[a][b] == (FigureType.BLACK_PAWN)) {
            Path += "BLACK_PAWN.png";
        }
        if (figures[a][b] == (FigureType.BLACK_BISHOP)) {
            Path += "BLACK_BISHOP.png";
        }
        if (figures[a][b] == (FigureType.BLACK_KNIGHT)) {
            Path += "BLACK_KNIGHT.png";
        }
        if (figures[a][b] == (FigureType.BLACK_ROOK)) {
            Path += "BLACK_ROOK.png";
        }
        if (figures[a][b] == (FigureType.BLACK_KING)) {
            Path += "BLACK_KING.png";
        }
        if (figures[a][b] == (FigureType.BLACK_QUEEN)) {
            Path += "BLACK_QUEEN.png";
        }
        if (figures[a][b] == (FigureType.WHITE_PAWN)) {
            Path += "WHITE_PAWN.png";
        }
        if (figures[a][b] == (FigureType.WHITE_BISHOP)) {
            Path += "WHITE_BISHOP.png";
        }
        if (figures[a][b] == (FigureType.WHITE_KNIGHT)) {
            Path += "WHITE_KNIGHT.png";
        }
        if (figures[a][b] == (FigureType.WHITE_ROOK)) {
            Path += "WHITE_ROOK.png";
        }
        if (figures[a][b] == (FigureType.WHITE_KING)) {
            Path += "WHITE_KING.png";
        }
        if (figures[a][b] == (FigureType.WHITE_QUEEN)) {
            Path += "WHITE_QUEEN.png";
        }
        try {
            image = ImageIO.read(new File(Path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
