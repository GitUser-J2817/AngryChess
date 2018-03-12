package mitrofanov82.edu.javagroup1.angry_chess.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.ImagesUtils;

public class WindowMenu extends JFrame {
    private JPanel spaceWindow = new JPanel();
    private WindowMenu windowMenu;
    private SwingUI controler;

    private JLabel logoAngry = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("angry")));
    private JLabel logoChess = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("chess")));

    private JLabel newGameImg = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("newGame")));
    private JLabel newGameActionImg = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("newGameAction")));

    private JLabel statisticGame = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("statistic")));
    private JLabel statisticGameAction = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("statisticAction")));

    private JLabel gameExit = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("exitGame")));
    private JLabel exitGameAction = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("exitAction")));

    public WindowMenu(SwingUI swingUI) {
        super("Angry Chess - MENU");
        this.controler = swingUI;
        windowMenu = this;

        // Settings window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        // Общая область для прилипания
        spaceWindow.setSize(800, 600);
        spaceWindow.setBackground(Color.white);
        spaceWindow.setLayout(null);
        add(spaceWindow);

        // БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        logoAngry.setLocation(0, 10);
        logoAngry.setSize(800, 100);
        logoChess.setLocation(0, 130);
        logoChess.setSize(800, 100);
        spaceWindow.add(logoAngry);
        spaceWindow.add(logoChess);

        // ИНТЕРАКТИВНАЯ кнопка НОВАЯ ИГРА
        newGameImg.setVisible(false);
        newGameImg.setLocation(200, 300);
        newGameImg.setSize(400, 50);
        spaceWindow.add(newGameImg);

        newGameActionImg.setLocation(175, 300);
        newGameActionImg.setSize(450, 50);
        spaceWindow.add(newGameActionImg);

        newGameActionImg.addMouseListener(new ActionOnNewGameButton());

        // ИНТЕРАКТИВНАЯ кнопка СТАТИСТИКА
        statisticGame.setSize(450, 50);
        statisticGame.setLocation(175, 370);
        statisticGame.setVisible(false);
        spaceWindow.add(statisticGame);

        statisticGameAction.setLocation(150, 370);
        statisticGameAction.setSize(500, 50);
        spaceWindow.add(statisticGameAction);

        statisticGameAction.addMouseListener(new ActionOnStatisticButton());

        // ИНТЕРАКТИВНАЯ кнопка ВЫХОД
        gameExit.setSize(450, 50);
        gameExit.setLocation(175, 440);
        gameExit.setVisible(false);
        spaceWindow.add(gameExit);

        exitGameAction.setLocation(150, 440);
        exitGameAction.setSize(500, 50);
        spaceWindow.add(exitGameAction);

        exitGameAction.addMouseListener(new ActionOnExitButton());
    }

    private class ActionOnNewGameButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            controler.callWindowPlayers();
            windowMenu.setVisible(false);
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
    }

    private class ActionOnStatisticButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            controler.callWindowStatistic();
            windowMenu.setVisible(false);
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
    }

    private class ActionOnExitButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            windowMenu.setVisible(false);
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
    }
}
