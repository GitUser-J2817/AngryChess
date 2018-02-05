package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

public interface IGameHistory {
    long getGameId ();

    GameStatusType getGameStatus ();

    IPlayer getWhitePlayer ();

    IPlayer getBlackPlayer ();
}
