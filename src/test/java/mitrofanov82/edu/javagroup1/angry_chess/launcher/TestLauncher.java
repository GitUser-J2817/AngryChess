package mitrofanov82.edu.javagroup1.angry_chess.launcher;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModel;
import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModelAPI;
import mitrofanov82.edu.javagroup1.angry_chess.model.engine.utilits.GameData;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.ChessPersistence;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.jdbc.JdbcPersistence;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.Player;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.SwingUI;

public class TestLauncher {

    public static void main(String[] args) throws Exception {
        IChessPersistenceAPI persistence = new JdbcPersistence(false);

        Player white = new Player("Pit");
        Player black = new Player("Joe");
        GameData game = new GameData(12, white, black);
        
        persistence.saveGameResults(game);
        List<IGameHistory> games = persistence.getGamesHistory();
        for (IGameHistory gameHistory: games) {
        	System.out.println("Game " + gameHistory.getGameId()
        		+ " White " + gameHistory.getWhitePlayer().getName()
        		+ " Black " + gameHistory.getBlackPlayer().getName()
        		+ " Result " + gameHistory.getGameStatus());
        }
    }

}
