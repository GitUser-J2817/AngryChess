package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;


public class WinMenuStartUI extends JFrame{
        private JPanel NameAngrys = new JPanel();
        private JLabel logoAngry = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("angry")));
        private JLabel logoChess = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("chess")));
        private JLabel newGameImg = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("newGame")));
        private JLabel newGameActionImg = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("newGameAction")));
        private JLabel statisticGame = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("statistic")));
        private JLabel statisticGameAction = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("statisticAction")));
        private JLabel gameExit = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("exitGame")));
        private JLabel exitGameAction = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("exitAction")));

    WinMenuStartUI(){
        super("AngryChess");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);

        //Общая область для прилипания
        add(NameAngrys);
        NameAngrys.setSize(800,600);
        //NameAngrys.setLocation(0,0);
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
                WinPlayersCreatedUI WinCreatedPlayers = new WinPlayersCreatedUI();
                WinCreatedPlayers.setVisible(true);
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
                WinStatisticGameUI Statistics = new WinStatisticGameUI();
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
}
