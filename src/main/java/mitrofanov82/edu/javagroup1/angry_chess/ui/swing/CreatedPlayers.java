package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class CreatedPlayers  implements IPlayer{
    private int randomName = (int)(Math.random()*1000);
    private String name = "Noname" + randomName;
    private int rating = 0;

    CreatedPlayers(){
        name = this.name;
        rating = this.rating;
    }

    CreatedPlayers (String Name){
        this.name = Name;
        this.rating = rating;
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
