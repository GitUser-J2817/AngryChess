package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModelAPI;
import mitrofanov82.edu.javagroup1.angry_chess.model.exceptions.ChessModelRuntimeException;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

public class SwingUI {
    // private IChessPersistenceAPI persistence;
    private ChessModelAPI model = null;

    private WindowMenu windowMenu = null;
    private WindowGame windowGame = null;
    private WindowPlayers windowPlayers = null;
    private WindowStatistic windowStatistic = null;

    private boolean figureIsChoise = false;
    private boolean moveIsChoise = false;
    private int fromX = 0;
    private int fromY = 0;
    private int toX = 0;
    private int toY = 0;

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

    public void callWindowGame(Player player1, Player player2) {
        try {
            long id = ((long) Math.random()) * 1000;
            IGame game = model.createNewGame(id, player1, player2);
            windowGame = new WindowGame(this, game);
            windowGame.setVisible(true);

        } catch (ChessModelException e) {
            // TODO Обработать ошибку если игра с таки id уже есть.
            System.exit(0);
        }

    }

    public IGame makeMove(IGame oldGame) {
        Coord from = new Coord(fromX, fromY);
        Coord to = new Coord(toX, toY);
        try {
            IGame newGame = model.makeMove(oldGame, from, to);
            figureIsChoise = false;
            moveIsChoise = false;
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

    public void addFrom(int x, int y) {
        System.out.println("Cordibate FROM set "+x+" - "+y);
        this.fromX = x;
        this.fromY = y;
    }

    public void addTo(int x, int y) {
        System.out.println("Cordibate TO set "+x+" - "+y);
        this.toX = x;
        this.toY = y;
    }
    
    public boolean figureIsChoise() {
        return figureIsChoise;
    }

    public void setFigureIsChoise(boolean flag) {
        System.out.println("Flag FigureIsChoise set "+flag);
        this.figureIsChoise = flag;
    }
    
    public boolean moveIsChoise() {
        return moveIsChoise;
    }

    public void setMoveIsChoise(boolean flag) {
        System.out.println("Flag MoveIsChoise set "+flag);
        this.moveIsChoise = flag;
    }

}
