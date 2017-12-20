package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

import java.util.List;

public interface ChessPersistenceAPI {
	void saveGameResults(IGame game);
	List<IGame> readGameResults(IPlayer p1, IPlayer p2);
}
