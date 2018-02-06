package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class WinStatisticGameUI extends JFrame {
    private JTable TableStats = new JTable(31,3);
    private JPanel StaticGame = new JPanel();
    private BufferedImage image = null;
    private JLabel LogoStatistic = new JLabel(new ImageIcon(ImageBufferedIcon("staticLogo")));
    private JLabel BackToMenuButton = new JLabel(new ImageIcon(ImageBufferedIcon("backButton")));
    private JLabel BackToMenuActionButton = new JLabel(new ImageIcon(ImageBufferedIcon("backActionButton")));


    WinStatisticGameUI(){
        super("AngryChess - Статистика");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        StaticGame.setLayout(null);
        StaticGame.setBackground(Color.white);
        StaticGame.setLocation(0,0);
        StaticGame.setSize(800,600);
        add(StaticGame);

        //БОЛЬШОЕ НАЗВАНИЕ - ЛОГО
        LogoStatistic.setLocation(0,10);
        LogoStatistic.setSize(800,100);
        StaticGame.add(LogoStatistic);

        //Таблица истории игр
        StaticGame.add(TableStats);
        TableStats.setLocation(75,150);
        TableStats.setSize(600,320);

        //ИНТЕРАКТИВНАЯ кнопка НАЗАД
        StaticGame.add(BackToMenuButton);
        BackToMenuButton.setLocation(250,500);
        BackToMenuButton.setSize(300,40);
        BackToMenuButton.setVisible(false);

        StaticGame.add(BackToMenuActionButton);
        BackToMenuActionButton.setLocation(250,500);
        BackToMenuActionButton.setSize(300,40);
        BackToMenuActionButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new WinMenuStartUI().setVisible(true);
                setVisible(false);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                BackToMenuActionButton.setVisible(false);
                BackToMenuButton.setVisible(true);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                BackToMenuActionButton.setVisible(true);
                BackToMenuButton.setVisible(false);
            }
        });
    }


    private BufferedImage ImageBufferedIcon (String name){
        String Path = "./src/main/resources/";
        if (name.equals("staticLogo")){
            Path += "statistic_logo.jpg";
        }else if (name.equals("backButton")){
            Path += "back.jpg";
        }else if (name.equals("backActionButton")){
            Path += "back_action.jpg";
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
