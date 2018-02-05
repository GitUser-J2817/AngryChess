package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import javax.imageio.ImageIO;
import javax.naming.Name;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WinCreateGameUI extends JFrame{
    private JLabel PlayerNameOne = new JLabel("Player 1(белые): ");
    private JLabel PlayerNamesTwo = new JLabel("Player 2(черные): ");
    private JLabel NewGameLable = new JLabel();
    private JLabel StartNewGameButton = new JLabel(new ImageIcon(ImageBufferedIcon("going")));
    private JLabel StartNewGameActionButton = new JLabel(new ImageIcon(ImageBufferedIcon("goingAction")));
    private JLabel BackMenuButton = new JLabel(new ImageIcon(ImageBufferedIcon("backMenu")));
    private JLabel BackMenuActionButton = new JLabel(new ImageIcon(ImageBufferedIcon("backMenuAction")));
    private JLabel NamePlayerOne = new JLabel();
    private JLabel NamePlayerTwo = new JLabel();
    private JPanel WinPlayers = new JPanel();
    private BufferedImage image = null;


    WinCreateGameUI(CreatedPlayers Player1, CreatedPlayers Player2) {
        super("AngryChess - New Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);


        WinPlayers.setLayout(null);
        WinPlayers.setBackground(Color.white);
        WinPlayers.setLocation(0,0);
        WinPlayers.setSize(800,600);
        add(WinPlayers);

        //БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        NewGameLable.setLocation(-5,10);
        NewGameLable.setSize(800,100);
        WinPlayers.add(NewGameLable);
        NewGameLable.setText(Player1.getName()+Player2.getName());

        //ИНТЕРАКТИВНАЯ кнопка НАЗАД
        WinPlayers.add(BackMenuButton);
        BackMenuButton.setLocation(80,450);
        BackMenuButton.setSize(300,50);
        BackMenuButton.setVisible(false);

        WinPlayers.add(BackMenuActionButton);
        BackMenuActionButton.setLocation(80 ,450);
        BackMenuActionButton.setSize(300,50);
        BackMenuActionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new WinPlayersCreatedUI().setVisible(true);
                setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                BackMenuActionButton.setVisible(false);
                BackMenuButton.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                BackMenuActionButton.setVisible(true);
                BackMenuButton.setVisible(false);
            }
        });






        //Надпись над полями ввода имени игроков
        WinPlayers.add(PlayerNameOne);
        PlayerNameOne.setLocation(130,280);
        PlayerNameOne.setSize(200,50);
        PlayerNameOne.setText("Белый: " + Player1.getName());
        WinPlayers.add(PlayerNamesTwo);
        PlayerNamesTwo.setLocation(505,280);
        PlayerNamesTwo.setSize(200,50);
        PlayerNamesTwo.setText("Черный: " +Player2.getName());



        //ИНТЕРАКТИВНАЯ кнопка НАЧАТЬ
        WinPlayers.add(StartNewGameButton);
        StartNewGameButton.setLocation(426,450);
        StartNewGameButton.setSize(300,50);
        StartNewGameButton.setVisible(false);

        WinPlayers.add(StartNewGameActionButton);
        StartNewGameActionButton.setLocation(426 ,450);
        StartNewGameActionButton.setSize(300,50);
        StartNewGameActionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                StartNewGameActionButton.setVisible(false);
                StartNewGameButton.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                StartNewGameActionButton.setVisible(true);
                StartNewGameButton.setVisible(false);
            }
        });
    }

    private BufferedImage ImageBufferedIcon (String name){
        String Path = "./src/main/resources/";
        if (name.equals("newGameLogo")){
            Path += "new_game_logo.jpg";
        }else if (name.equals("backMenu")){
            Path += "back.jpg";
        }else if (name.equals("backMenuAction")){
            Path += "back_action.jpg";
        }else if (name.equals("going")){
            Path += "going.jpg";
        }else if (name.equals("goingAction")){
            Path += "going_action.jpg";
        }else if (name.equals("avatar")){
            Path += "blank_avatar.jpg";
        }

        try {
            image = ImageIO.read(new File(Path));
            return image;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
