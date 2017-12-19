package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface ChessPersistenceAPI {
	void saveGameResults(Game game);
	List<Game> readGameResults(Player p1, Player p2);
}
