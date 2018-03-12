package tests_from_model;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModel;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

public class TestsModel {

    public static void main(String[] args) {

        boolean test1 = smokeTest();
        boolean test2 = manyMoveTest();
        boolean test3 = equelsID();
        boolean test4 = incorectCoord();

        System.out.println("Test on correct data is:" + test1);
        System.out.println("Test on many moves is:" + test2);
        System.out.println("Test on incorrect data(ID) is :" + test3);
        System.out.println("Test on incorrect data(Coord) is :" + test4);
    }

    /**
     * Smoke-test for the model
     */
    private static boolean smokeTest() {
        ChessModel scm = new ChessModel();
        IPlayer p1 = new TSMPlayer("Player1");
        IPlayer p2 = new TSMPlayer("Player2");
        try {
            IGame game = scm.createNewGame(13, p1, p2);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            Coord from = new Coord(1, 1);
            Coord to = new Coord(1, 3);
            game = scm.makeMove(game, from, to);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            return true;
        } catch (IncorrectMoveException e) {
            e.printStackTrace();
            return false;
        } catch (ChessModelException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Smoke-test for many moves the model
     */
    private static boolean manyMoveTest() {
        ChessModel scm = new ChessModel();
        IPlayer p1 = new TSMPlayer("Player1");
        IPlayer p2 = new TSMPlayer("Player2");
        IGame game = null;

        try {
            game = scm.createNewGame(13, p1, p2);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            Coord from2 = new Coord(1, 6);
            Coord to2 = new Coord(1, 4);
            game = scm.makeMove(game, from2, to2);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            Coord from3 = new Coord(1, 0);
            Coord to3 = new Coord(2, 2);
            game = scm.makeMove(game, from3, to3);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            return true;
        } catch (IncorrectMoveException e) {
            e.printStackTrace();
            return false;
        } catch (ChessModelException e) {
            e.printStackTrace();
            return false;
        }

    }

    /**
     * Test for working off incorrect data (ID)
     */
    private static boolean equelsID() {
        ChessModel scm = new ChessModel();
        IPlayer p1 = new TSMPlayer("Player1");
        IPlayer p2 = new TSMPlayer("Player2");
        try {
            IGame game = scm.createNewGame(13, p1, p2);
            game.getGameStatus();
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            IGame game2 = scm.createNewGame(13, p1, p2);
            game2.getGameStatus();
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            return false;
        } catch (ChessModelException e) {
            return true;
        }
    }

    /**
     * Test for working off incorrect data (Coord)
     */
    private static boolean incorectCoord() {
        // Test make move (incorrect data)
        try {
            ChessModel scm = new ChessModel();
            IPlayer p1 = new TSMPlayer("Player1");
            IPlayer p2 = new TSMPlayer("Player2");
            Coord from = new Coord(1, 1);
            Coord to = new Coord(-1, 1);
            IGame game = scm.createNewGame(13, p1, p2);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME

            game = scm.makeMove(game, from, to);
            // printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME
            
            return false;
        } catch (IncorrectMoveException e) {
            return true;
        } catch (ChessModelException e) {
            return true;
        }
    }

    // Utility methods
    public static void printGame(IGame game) {
        System.out.println("\n\n");
        System.out.println("Game ID:" + game.getGameId());
        System.out.println("Players:" + game.getWhitePlayer().getName() + " - " + game.getBlackPlayer().getName());
        System.out.println("Game status:" + game.getGameStatus());
        printBoard(game.getCurrentPosition());
        System.out.println("\n");
        System.out.println("History:\n" + printHistory(game.getHistoryLog()));
        System.out.println("\n\n");
    }

    public static String printHistory(ArrayList<String> historyLog) {
        String history = "";

        for (String string : historyLog) {
            history += "[" + string + "]\n";

        }
        return history;
    }

    public static void printBoard(FigureType[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != null) {
                    System.out.print("[" + board[i][j] + "]\t");
                } else {
                    System.out.print("[          ]\t");
                }
            }
            System.out.println("\n");
        }
    }

}
