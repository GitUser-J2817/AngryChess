package mitrofanov82.edu.javagroup1.angry_chess.ui;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModelAPI;
import mitrofanov82.edu.javagroup1.angry_chess.model.exceptions.ChessModelRuntimeException;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.CreatedPlayers;

public class SwingUI {
    // private IChessPersistenceAPI persistence;
    private ChessModelAPI model = null;

    private WindowMenu windowMenu = null;
    private WindowGame windowGame = null;
    private WindowPlayers windowPlayers = null;
    private WindowStatistic windowStatistic = null;

    public SwingUI(IChessPersistenceAPI persistence, ChessModelAPI model) {
        // this.persistence = persistence;
        this.model = model;
    }

    public void callWindowMenu() {
        if (windowMenu == null) {
            windowMenu = new WindowMenu(this);
        }
        windowMenu.setVisible(true);
    }

    public void callWindowPlayers() {
        if (windowPlayers == null) {
            windowPlayers = new WindowPlayers(this);
        }
        windowPlayers.setVisible(true);
    }

    public void callWindowStatistic() {
        if (windowStatistic == null) {
            windowStatistic = new WindowStatistic(this);
        }
        windowStatistic.setVisible(true);
    }

    public void callWindowGame(CreatedPlayers player1, CreatedPlayers player2) {        
        try {
            IGame game = model.createNewGame((((long) Math.random()) * 1000), player1, player2);
            windowGame = new WindowGame(this, game);
            windowGame.setVisible(true);

        } catch (ChessModelException e) {
            // TODO Обработать ошибку если игра с таки id уже есть.
            System.exit(0);
        }

    }

    public IGame makeMove(IGame oldGame, Coord from, Coord to) {
        try {
            IGame newGame = model.makeMove(oldGame, from, to);
            return newGame;

        } catch (IncorrectMoveException e) {
            // TODO Обработка ошибки неверного хода. Кинуть окошко.
            return oldGame;
        } catch (ChessModelRuntimeException e) {
            // TODO Неизвесная ошибка, или такой игры уже не существует.
            return oldGame;
        }
    }

    public IGame endGame(IGame oldGame, GameStatusType status) {
        IGame newGame = model.endGame(oldGame, status);
        return newGame;
    }

}
