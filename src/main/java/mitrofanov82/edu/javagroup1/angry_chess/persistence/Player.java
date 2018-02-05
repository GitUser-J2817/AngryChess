package mitrofanov82.edu.javagroup1.angry_chess.persistence;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class Player implements IPlayer {

    private String name;
    private int rating;

    public Player (String name, int rating) {
	this.name = name;
	this.rating = rating;
    }

    public Player () {
    }

    public String getName() {
	return name;
    }

    public int getRating() {
	return rating;
    }
}
