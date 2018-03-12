package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

/**
 *  Interface describes a class storing information for saving a games
 */
public interface IGameHistory {
    /**
     * Returns ID of the current saved game.
     * 
     * @return ID as long number
     */
    long getGameId ();

    /**
     * Returns status of the current saved game.
     * 
     * @return status as <i>enum</i> <b>GameStatusType</b>.
     */
    GameStatusType getGameStatus ();

    /**
     * Returns player on Light Side
     * 
     * @return IPLayer
     */
    IPlayer getWhitePlayer ();

    /**
     * Returns player on Dark Side
     * 
     * @return IPLayer
     */
    IPlayer getBlackPlayer ();
}
