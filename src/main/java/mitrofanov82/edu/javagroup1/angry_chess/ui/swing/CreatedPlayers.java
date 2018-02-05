package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

import static java.lang.Math.*;

public class CreatedPlayers  implements IPlayer{
    private int randomName = (int)(Math.random()*1000);
    private String Name = "noname" + randomName;
    private int Rating = 0;

    CreatedPlayers(){
        Name = this.Name;
        Rating = this.Rating;
    }

    CreatedPlayers (String Name){
        this.Name = Name;
    }


    @Override
    public String getName() {
        return Name;
    }

    @Override
    public int getRating() {
        return Rating;
    }
}
