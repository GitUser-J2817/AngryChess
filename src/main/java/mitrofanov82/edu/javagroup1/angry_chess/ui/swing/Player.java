package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class Player implements IPlayer {
    private String name = "";
    private int rating = 0;
    
    public Player() {
        
    }

    public Player(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getRating() {
        return rating;
    }
}
