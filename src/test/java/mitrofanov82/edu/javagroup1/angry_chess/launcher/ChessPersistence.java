package mitrofanov82.edu.javagroup1.angry_chess.launcher;

import java.util.List;

import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class ChessPersistence implements IChessPersistenceAPI {

    @Override
    public void saveGameResults(IGame game) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<IGame> getGamesHistory() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<IGame> getGamesHistory(IPlayer p) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<IGame> getGamesHistory(IPlayer p1, IPlayer p2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<IPlayer> getAllRegisteredPlayers() {
        // TODO Auto-generated method stub
        return null;
    }

}
