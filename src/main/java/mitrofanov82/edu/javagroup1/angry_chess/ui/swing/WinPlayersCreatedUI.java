package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.CreatedPlayers;


public class WinPlayersCreatedUI extends JFrame{
    private JLabel PlayerNameOne = new JLabel("Введите имя игрока (белые): ");
    private JLabel PlayerNamesTwo = new JLabel("Введите имя игрока (черные): ");
    private JLabel NewGameLable = new JLabel(new ImageIcon(ImageBufferedIcon("newGameLogo")));
    private JLabel StartNewGameButton = new JLabel(new ImageIcon(ImageBufferedIcon("going")));
    private JLabel StartNewGameActionButton = new JLabel(new ImageIcon(ImageBufferedIcon("goingAction")));
    private JLabel BackMenuButton = new JLabel(new ImageIcon(ImageBufferedIcon("backMenu")));
    private JLabel BackMenuActionButton = new JLabel(new ImageIcon(ImageBufferedIcon("backMenuAction")));
    private JLabel avatarPlayerOne = new JLabel(new ImageIcon(ImageBufferedIcon("avatar")));
    private JLabel avatarPlayerTwo = new JLabel(new ImageIcon(ImageBufferedIcon("avatar")));
    private JTextField NamePlayerOne = new JTextField("Игрок 1",25);
    private JTextField NamePlayerTwo = new JTextField("Игрок 2", 50);
    private JPanel WinPlayers = new JPanel();
    private BufferedImage image = null;


    WinPlayersCreatedUI() {
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
                new WinMenuStartUI().setVisible(true);
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


        //Размещаем Аватарки юзверов
        WinPlayers.add(avatarPlayerOne);
        avatarPlayerOne.setLocation(150,150);
        avatarPlayerOne.setSize(125,125);

        WinPlayers.add(avatarPlayerTwo);
        avatarPlayerTwo.setLocation(525,150);
        avatarPlayerTwo.setSize(125,125);



        //Надпись над полями ввода имени игроков
        WinPlayers.add(PlayerNameOne);
        PlayerNameOne.setLocation(130,280);
        PlayerNameOne.setSize(200,50);

        WinPlayers.add(PlayerNamesTwo);
        PlayerNamesTwo.setLocation(505,280);
        PlayerNamesTwo.setSize(200,50);


        //Поля ввода имен игроков
        WinPlayers.add(NamePlayerOne);
        NamePlayerOne.setLocation(125,330);
        NamePlayerOne.setSize(200,30);
        WinPlayers.add(NamePlayerTwo);
        NamePlayerTwo.setLocation(500,330);
        NamePlayerTwo.setSize(200,30);


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
                CreatedPlayers Player1;
                CreatedPlayers Player2;
                    if (NamePlayerOne.getText().equals("Игрок 1")) {
                        Player1 = new CreatedPlayers();
                    } else if (NamePlayerOne.getText().equals("")){
                        Player1 = new CreatedPlayers();
                    } else {
                        Player1 = new CreatedPlayers(NamePlayerOne.getText());
                    }
                    if (NamePlayerTwo.getText().equals("Игрок 2")) {
                        Player2 = new CreatedPlayers();
                    } else if (NamePlayerTwo.getText().equals("")) {
                        Player2 = new CreatedPlayers();
                    } else {
                        Player2 = new CreatedPlayers(NamePlayerTwo.getText());
                    }

                WinCreateGameUI WinCreateGame = new WinCreateGameUI(Player1, Player2);
                WinCreateGame.setVisible(true);
                setVisible(false);
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
