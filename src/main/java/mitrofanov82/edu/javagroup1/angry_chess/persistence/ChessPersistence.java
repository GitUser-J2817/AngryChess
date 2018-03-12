package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.GameStatusType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGameHistory;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

/**
 * The class that implements the management of the history of games
 * 
 * @author Alexander Neznaev
 */
public class ChessPersistence implements IChessPersistenceAPI {

    private List<IGameHistory> savedGamesResult = new ArrayList<IGameHistory>();
    private String path = "src/main/resources/history.save";

    /**
     * When creating any constructor saves all the results of the games into memory
     */
    {
        BufferedReader reader = readerCreator();
        
        try {
            while (reader.ready()) {
                String[] history = reader.readLine().split(",");

                long gameId = Long.parseLong(history[0]);
                GameStatusType status = GameStatusType.valueOf(history[1]);
                IPlayer white = new Player(history[2], Integer.parseInt(history[3]));
                IPlayer black = new Player(history[4], Integer.parseInt(history[5]));

                IGameHistory currentGameHistory = new GameHistory(gameId, status, white, black);
                savedGamesResult.add(currentGameHistory);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * The Constructor with default saving directory
     */
    public ChessPersistence() {
    }
    
    /**
     * The Constructor with custom saving directory
     * 
     * @param path to saving directory
     */
    public ChessPersistence(String path) {
        this.path = path;
    }

    public void saveGameResults(IGame game) {
        IPlayer whitePLayer = game.getWhitePlayer();
        IPlayer blackPLayer = game.getBlackPlayer();
        GameStatusType winner = game.getGameStatus();

        int whiteIncrement;
        int blackIncrement;
        
        if (winner.equals(GameStatusType.DRAW)) {
            whiteIncrement = blackIncrement = 1;
        } else {
            whiteIncrement = winner.equals(GameStatusType.WHITE_WIN) ? 2 : 0;
            blackIncrement = winner.equals(GameStatusType.BLACK_WIN) ? 2 : 0;
        }

        String toWrite = game.getGameId() + "," + winner + "," + whitePLayer.getName() + ","
                + (whitePLayer.getRating() + whiteIncrement) + "," + blackPLayer.getName() + ","
                + (blackPLayer.getRating() + blackIncrement);

        BufferedWriter bufferedWriter = null;
        try {
            File file = new File(path);
            Writer writer = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(writer);
            
            bufferedWriter.write(toWrite + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bufferedWriter != null) bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public List<IGameHistory> getGamesHistory() {
        return savedGamesResult;
    }

    public List<IGameHistory> getGamesHistory(IPlayer p) {
        List<IGameHistory> playerGames = new ArrayList<IGameHistory>();
        for (IGameHistory game : savedGamesResult) {
            if (game.getWhitePlayer().equals(p) || game.getBlackPlayer().equals(p)) {
                playerGames.add(game);
            }
        }
        return playerGames;
    }

    public List<IGameHistory> getGamesHistory(IPlayer p1, IPlayer p2) {
        List<IGameHistory> playersGames = new ArrayList<IGameHistory>();
        for (IGameHistory game : savedGamesResult) {
            if (game.getWhitePlayer().equals(p1) && game.getBlackPlayer().equals(p2)
                    || game.getWhitePlayer().equals(p2) && game.getBlackPlayer().equals(p1)) {
                playersGames.add(game);
            }
        }
        return playersGames;
    }

    public List<IPlayer> getAllRegisteredPlayers() {
        Set<IPlayer> players = new TreeSet<IPlayer>(new Comparator<IPlayer>() {
            public int compare(IPlayer p1, IPlayer p2) {
                return p1.getName().compareTo(p2.getName());
            }
        });
        for (int i = savedGamesResult.size() - 1; i >= 0; i--) {
            IPlayer white = savedGamesResult.get(i).getWhitePlayer();
            IPlayer black = savedGamesResult.get(i).getBlackPlayer();

            players.add(white);
            players.add(black);
        }
        return new ArrayList<IPlayer>(players);
    }

    private BufferedReader readerCreator() {
        BufferedReader bufferedReader = null;
        try {
            Reader reader = new FileReader(path);
            bufferedReader = new BufferedReader(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bufferedReader;
    }
}
