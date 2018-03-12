package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

/**
 * @author Alexander Neznaev
 */
public class Player implements IPlayer {

    private String name;
    private int rating;

    /**
     * Create a new Player object
     * 
     * @param name of the current player
     * @param rating of the current player 
     */
    public Player(String name, int rating) {
        this.name = name;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public int getRating() {
        return rating;
    }
}
