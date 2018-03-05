package mitrofanov82.edu.javagroup1.angry_chess.shared_model;

/**
 * The interface describes a chess player
 */
public interface IPlayer {
    
    /**
     * Returns name of the current player
     * 
     * @return name as String
     */
    String getName();

    /**
     * Returns rating of the current player
     * 
     * @return rating as Integer
     */
    int getRating();
}
