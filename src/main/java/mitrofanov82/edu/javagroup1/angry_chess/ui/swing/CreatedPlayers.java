package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class CreatedPlayers implements IPlayer {
    private String name = "Noname" + (int) (Math.random() * 1000);
    private int rating = 0;

    CreatedPlayers() {
    }

    CreatedPlayers(String name) {
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
