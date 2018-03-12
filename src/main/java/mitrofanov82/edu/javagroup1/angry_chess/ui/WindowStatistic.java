package mitrofanov82.edu.javagroup1.angry_chess.ui;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.ImagesUtils;

public class WindowStatistic extends JFrame {
    private JPanel spaceWindow = new JPanel();
    private WindowStatistic windowStatistic;
    private SwingUI controler;

    private JTable tableStats = new JTable(31, 3);

    private JLabel logoStatistic = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("staticLogo")));

    private JLabel backToMenuButton = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("backButton")));
    private JLabel backToMenuActionButton = new JLabel(
            new ImageIcon(ImagesUtils.ImageBufferedIcon("backActionButton")));

    public WindowStatistic(SwingUI swingUI) {
        super("Angry Chess - STATISTIC");
        this.controler = swingUI;
        windowStatistic = this;

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        spaceWindow.setLayout(null);
        spaceWindow.setBackground(Color.white);
        spaceWindow.setLocation(0, 0);
        spaceWindow.setSize(800, 600);
        add(spaceWindow);

        // БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        logoStatistic.setLocation(0, 10);
        logoStatistic.setSize(800, 100);
        spaceWindow.add(logoStatistic);

        // Таблица истории игр
        tableStats.setLocation(75, 150);
        tableStats.setSize(600, 320);
        spaceWindow.add(tableStats);

        // ИНТЕРАКТИВНАЯ кнопка НАЗАД
        backToMenuButton.setLocation(250, 500);
        backToMenuButton.setSize(300, 40);
        backToMenuButton.setVisible(false);
        spaceWindow.add(backToMenuButton);

        backToMenuActionButton.setLocation(250, 500);
        backToMenuActionButton.setSize(300, 40);
        spaceWindow.add(backToMenuActionButton);

        backToMenuActionButton.addMouseListener(new ActionOnBackMenuButton());

    }

    private class ActionOnBackMenuButton extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            controler.callWindowMenu();
            windowStatistic.setVisible(false);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            backToMenuActionButton.setVisible(false);
            backToMenuButton.setVisible(true);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            backToMenuActionButton.setVisible(true);
            backToMenuButton.setVisible(false);
        }
    }

}
