package tests_from_model;

import java.util.ArrayList;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModelAPI;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.ChessModelException;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions.IncorrectMoveException;

public class TestsModel {

	public static void main(String[] args) {

		boolean test1 = smokeTest();
		boolean test2 = test1();
		
		System.out.println("Test on correct data is:" + test1);
		System.out.println("Test on incorrect data is:" + test2);
	}

	/**
	 * Smoke-test for the model
	 */
	private static boolean smokeTest() {
		ChessModelAPI scm = new ChessModelAPI();
		IPlayer p1 = new TSMPlayer("Player1");
		IPlayer p2 = new TSMPlayer("Player2");
		IGame game = null;

		// Test creating game (correct data)
		try {
			game = scm.createNewGame(13, p1, p2);
			System.out.println("TEST ON CORECT ID IS SUCSESFULL");
			printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME
		} catch (ChessModelException e) {
			e.printStackTrace();
			return false;
		}

		// Test make move (correct data)
		try {
			Coord from = new Coord(1, 1);
			Coord to = new Coord(1, 3);
			game = scm.makeMove(game, from, to);
			System.out.println("TEST ON CORECT CORDINATE IS SUCSESFULL");
			printGame(game);// PRINT ALL DATAS IN THE CURRENT GAME
		} catch (IncorrectMoveException e) {
			e.printStackTrace();
			return false;
		}

		// TODO create more tests
		return true;
	}
	
	/**
	 * Test for working off incorrect data
	 */
	private static boolean test1() {
		ChessModelAPI scm = new ChessModelAPI();
		IPlayer p1 = new TSMPlayer("Player1");
		IPlayer p2 = new TSMPlayer("Player2");
		IGame game = null, game2 = null;

		// Test creating game (incorrect data)

		try {
			game = scm.createNewGame(13, p1, p2);
			game2 = scm.createNewGame(13, p1, p2);
			//
			return false;
		} catch (ChessModelException e) {
			System.out.println("TEST ON INCORECT ID IS SUCSESFULL");
		}

		// Test make move (incorrect data)
		try {
			Coord from = new Coord(1, 1);
			Coord to = new Coord(-1, 1);
			game = scm.makeMove(game, from, to);
			//
			return false;
		} catch (IncorrectMoveException e) {
			System.out.println("TEST ON INCORECT CORDINATE IS SUCSESFULL");
		}
		return true;
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
