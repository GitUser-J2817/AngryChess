package angrychess.swing.ui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuStart extends JFrame{
        private JPanel NameAngrys = new JPanel();
        private BufferedImage image = null;
        private JLabel logoAngry = new JLabel(new ImageIcon(ImageBufferedIcon("angry")));
        private JLabel logoChess = new JLabel(new ImageIcon(ImageBufferedIcon("chess")));
        private JLabel newGameImg = new JLabel(new ImageIcon(ImageBufferedIcon("newGame")));
        private JLabel newGameActionImg = new JLabel(new ImageIcon(ImageBufferedIcon("newGameAction")));
        private JLabel statisticGame = new JLabel(new ImageIcon(ImageBufferedIcon("statistic")));
        private JLabel statisticGameAction = new JLabel(new ImageIcon(ImageBufferedIcon("statisticAction")));
        private JLabel gameExit = new JLabel(new ImageIcon(ImageBufferedIcon("exitGame")));
        private JLabel exitGameAction = new JLabel(new ImageIcon(ImageBufferedIcon("exitAction")));

    MenuStart(){
        super("AngryChess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);
        setVisible(true);

        //Общая область для прилипания
        add(NameAngrys);
        NameAngrys.setSize(800,600);
        NameAngrys.setLocation(0,0);
        NameAngrys.setBackground(Color.white);
        NameAngrys.setLayout(null);

        //БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        logoAngry.setLocation(0,10);
        logoAngry.setSize(800,100);
        logoChess.setLocation(0,130);
        logoChess.setSize(800,100);
        NameAngrys.add(logoAngry);
        NameAngrys.add(logoChess);

        //ИНТЕРАКТИВНАЯ кнопка НОВАЯ ИГРА
        NameAngrys.add(newGameImg);
        newGameImg.setVisible(false);
        newGameImg.setLocation(200,300);
        newGameImg.setSize(400,50);

        NameAngrys.add(newGameActionImg);
        newGameActionImg.setLocation(175,300);
        newGameActionImg.setSize(450,50);

        newGameActionImg.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PlayersCreated CreatedPlayers = new PlayersCreated();
                CreatedPlayers.setVisible(true);
                setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                newGameActionImg.setVisible(false);
                newGameImg.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                newGameActionImg.setVisible(true);
                newGameImg.setVisible(false);
            }
        });

        //ИНТЕРАКТИВНАЯ кнопка СТАТИСТИКА
        NameAngrys.add(statisticGame);
        statisticGame.setSize(450,50);
        statisticGame.setLocation(175,370);
        statisticGame.setVisible(false);

        NameAngrys.add(statisticGameAction);
        statisticGameAction.setLocation(150,370);
        statisticGameAction.setSize(500,50);

        statisticGameAction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                StatisticGame Statistics = new StatisticGame();
                Statistics.setVisible(true);
                setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                statisticGameAction.setVisible(false);
                statisticGame.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                statisticGameAction.setVisible(true);
                statisticGame.setVisible(false);
            }

        });

        //ИНТЕРАКТИВНАЯ кнопка ВЫХОД
        NameAngrys.add(gameExit);
        gameExit.setSize(450,50);
        gameExit.setLocation(175,440);
        gameExit.setVisible(false);

        NameAngrys.add(exitGameAction);
        exitGameAction.setLocation(150,440);
        exitGameAction.setSize(500,50);

        exitGameAction.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                exitGameAction.setVisible(false);
                gameExit.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                exitGameAction.setVisible(true);
                gameExit.setVisible(false);
            }
        });

    }

    private BufferedImage ImageBufferedIcon (String name){
        String Path = "resources/";
        if (name.equals("angry")){
            Path += "angry.jpg";
        }else if (name.equals("chess")){
            Path += "chess.jpg";
        }else if (name.equals("newGame")){
            Path += "new_game.jpg";
        }else if (name.equals("newGameAction")){
            Path += "new_game_action.jpg";
        }else if (name.equals("statistic")){
            Path += "statistic.jpg";
        }else if (name.equals("statisticAction")){
            Path += "statistic_action.jpg";
        }else if (name.equals("exitGame")){
            Path += "exit.jpg";
        }else if (name.equals("exitAction")){
            Path += "exit_action.jpg";
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