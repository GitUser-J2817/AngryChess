package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class WindowPlayers extends JFrame {
    private JPanel spaceWindow = new JPanel();
    private WindowPlayers windowPlayers;
    private SwingUI controler;

    private JLabel playerNameOne = new JLabel("Введите имя игрока (белые): ");
    private JLabel playerNamesTwo = new JLabel("Введите имя игрока (черные): ");

    private JLabel newGameLable = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("newGameLogo")));

    private JLabel startNewGameButton = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("going")));
    private JLabel startNewGameActionButton = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("goingAction")));

    private JLabel backMenuButton = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("backMenu")));
    private JLabel backMenuActionButton = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("backMenuAction")));

    private JLabel avatarPlayerOne = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatar")));
    private JLabel avatarPlayerTwo = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatar")));

    private JTextField namePlayerOne = new JTextField("Игрок 1", 25);
    private JTextField namePlayerTwo = new JTextField("Игрок 2", 50);

    public WindowPlayers(SwingUI swingUI) {
        super("AngryChess - Create NEW GAME");
        this.controler = swingUI;
        windowPlayers = this;

        // Settings window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        // Общая область для прилипания
        spaceWindow.setLayout(null);
        spaceWindow.setBackground(Color.white);
        spaceWindow.setLocation(0, 0);
        spaceWindow.setSize(800, 600);
        this.add(spaceWindow);

        // БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        newGameLable.setLocation(-5, 10);
        newGameLable.setSize(800, 100);
        spaceWindow.add(newGameLable);

        // ИНТЕРАКТИВНАЯ кнопка НАЗАД
        backMenuButton.setLocation(80, 450);
        backMenuButton.setSize(300, 50);
        backMenuButton.setVisible(false);
        spaceWindow.add(backMenuButton);

        backMenuActionButton.setLocation(80, 450);
        backMenuActionButton.setSize(300, 50);
        spaceWindow.add(backMenuActionButton);

        backMenuActionButton.addMouseListener(new ActionOnBackMenuButton());

        // Размещаем Аватарки юзверов
        avatarPlayerOne.setLocation(150, 150);
        avatarPlayerOne.setSize(125, 125);
        spaceWindow.add(avatarPlayerOne);

        avatarPlayerTwo.setLocation(525, 150);
        avatarPlayerTwo.setSize(125, 125);
        spaceWindow.add(avatarPlayerTwo);

        // Надпись над полями ввода имени игроков
        playerNameOne.setLocation(130, 280);
        playerNameOne.setSize(200, 50);
        spaceWindow.add(playerNameOne);

        playerNamesTwo.setLocation(505, 280);
        playerNamesTwo.setSize(200, 50);
        spaceWindow.add(playerNamesTwo);

        // Поля ввода имен игроков
        namePlayerOne.setLocation(125, 330);
        namePlayerOne.setSize(200, 30);
        spaceWindow.add(namePlayerOne);

        namePlayerTwo.setLocation(500, 330);
        namePlayerTwo.setSize(200, 30);
        spaceWindow.add(namePlayerTwo);

        // ИНТЕРАКТИВНАЯ кнопка НАЧАТЬ
        startNewGameButton.setLocation(426, 450);
        startNewGameButton.setSize(300, 50);
        startNewGameButton.setVisible(false);
        spaceWindow.add(startNewGameButton);

        startNewGameActionButton.setLocation(426, 450);
        startNewGameActionButton.setSize(300, 50);
        spaceWindow.add(startNewGameActionButton);

        startNewGameActionButton.addMouseListener(new ActionOnNewGameButton());

    }

    private class ActionOnBackMenuButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            controler.callWindowMenu();
            windowPlayers.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            backMenuActionButton.setVisible(false);
            backMenuButton.setVisible(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            backMenuActionButton.setVisible(true);
            backMenuButton.setVisible(false);
        }
    }

    private class ActionOnNewGameButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Player Player1 = new Player(namePlayerOne.getText());
            Player Player2 = new Player(namePlayerTwo.getText());
            controler.callWindowGame(Player1, Player2);
            windowPlayers.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            startNewGameActionButton.setVisible(false);
            startNewGameButton.setVisible(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            startNewGameActionButton.setVisible(true);
            startNewGameButton.setVisible(false);
        }
    }
}
