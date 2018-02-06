package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WinCreateGameUI extends JFrame{
    private JLabel nameWhite = new JLabel();
    private JLabel nameBlack = new JLabel();
    private JLabel BackgroundChessboard = new JLabel(new ImageIcon(ImageBufferedIcon("backgroundChessBoard.jpg")));
    private JLabel AvatarWhitePlayer = new JLabel(new ImageIcon(ImageBufferedIcon("avatarWhite")));
    private JLabel AvatarBlackPlayer = new JLabel(new ImageIcon(ImageBufferedIcon("avatarBlack")));
    private JTextArea LogChat = new JTextArea(9000,20);
    private JButton BackMenuWhite = new JButton("Сдаться");
    private JButton BackMenuBlack = new JButton("Сдаться");
    private JButton HitWhite = new JButton("Походить");
    private JButton CancelHitWhite = new JButton("Отменить ход");
    private JButton HitBlack = new JButton("Походить");
    private JButton CancelHitBlack = new JButton("Отменить ход");
    private JPanel WinGameWhitePlayerPanel = new JPanel();
    private JPanel WinGameBlackPlayerPanel = new JPanel();
    private JPanel WinGameChessboardPanel = new JPanel();
    private BufferedImage image = null;
    private Border etched = BorderFactory.createEtchedBorder();
    private Border titled = BorderFactory.createTitledBorder(etched);


    WinCreateGameUI(CreatedPlayers Player1, CreatedPlayers Player2) {
        super("Game: " + Player1.getName() + " VS " + Player2.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 640);
        setMinimumSize(new Dimension(800,600));
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        //Panel Chessboard
        add(WinGameChessboardPanel);
        WinGameChessboardPanel.setLayout(null);
        WinGameChessboardPanel.setBackground(Color.lightGray);
        WinGameChessboardPanel.setLocation(170, 0);
        WinGameChessboardPanel.setSize(630,610);
        //Разобраться с растягивалкой
        //WinGameChessboardPanel.setMinimumSize(new Dimension(620,600));
        //WinGameChessboardPanel.setMaximumSize(new Dimension(1750,1080));
        WinGameChessboardPanel.add(BackgroundChessboard);
        BackgroundChessboard.setLocation(60,20);
        BackgroundChessboard.setSize(new Dimension(500,500));
        BackgroundChessboard.setBorder(titled);
        //Добавить реализацию ЛогЧата ***
        JScrollPane Scroll = new JScrollPane(LogChat);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        LogChat.setAutoscrolls(true);
        WinGameChessboardPanel.add(LogChat);
        LogChat.setLocation(60,535);
        LogChat.setBackground(Color.white);
        LogChat.setText("***Start NEW GAME " + Player1.getName() + " VS " + Player2.getName() + "***\n\r");
        LogChat.append("Ходит " + Player1.getName() + " ...\n\r");
        LogChat.setCaretPosition(LogChat.getDocument().getLength());
        LogChat.setEditable(false);
        LogChat.setSize(500,50);
        LogChat.setBorder(titled);

        //Panel WhitePlayer
        add(WinGameWhitePlayerPanel);
        WinGameWhitePlayerPanel.setLayout(null);
        WinGameWhitePlayerPanel.setBackground(Color.orange);
        WinGameWhitePlayerPanel.setLocation(0, 0);
        WinGameWhitePlayerPanel.setSize(170,2000);
        WinGameWhitePlayerPanel.add(AvatarWhitePlayer);
        AvatarWhitePlayer.setLocation(20,20);
        AvatarWhitePlayer.setSize(130,130);
        WinGameWhitePlayerPanel.add(nameWhite);
        nameWhite.setText(Player1.getName());
        nameWhite.setLocation(25,155);
        nameWhite.setSize(130,50);

        //Added Buttons and Listeners for WhitePlayer
        WinGameWhitePlayerPanel.add(HitWhite);
        HitWhite.setSize(120,30);
        HitWhite.setLocation(25,200);
        HitWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WinGameWhitePlayerPanel.setVisible(false);
                WinGameChessboardPanel.setLocation(0,0);
                WinGameChessboardPanel.setBackground(Color.black);
                LogChat.append("Ходит " + Player2.getName() + " ...\n\r");
                WinGameBlackPlayerPanel.setVisible(true);
            }
        });


        WinGameWhitePlayerPanel.add(CancelHitWhite);
        CancelHitWhite.setSize(120,30);
        CancelHitWhite.setLocation(25,250);

        WinGameWhitePlayerPanel.add(BackMenuWhite);
        BackMenuWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane.showOptionDialog( WinCreateGameUI.this,"Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WinCreateGameUI.this,
                            "" + Player1.getName() + " проиграл!\n\r" +
                                    "Черные выиграли!\n\r" +
                                    "Рейтинг " + Player1.getName() + " : " + (Player1.getRating()-1) + "\n\r" +
                                    "Рейтинг " + Player2.getName() + " : " + (Player2.getRating()+1));
                    new WinMenuStartUI().setVisible(true);
                    setVisible(false);
                }
            }
        });
        BackMenuWhite.setSize(120,30);
        BackMenuWhite.setLocation(25,550);





        //Panel BlackPlayer
        WinGameBlackPlayerPanel.setLayout(null);
        WinGameBlackPlayerPanel.setLocation(630,0);
        WinGameBlackPlayerPanel.setBackground(Color.yellow);
        add(WinGameBlackPlayerPanel);
        WinGameBlackPlayerPanel.setSize(170,2000);
        WinGameBlackPlayerPanel.add(AvatarBlackPlayer);
        AvatarBlackPlayer.setLocation(20,20);
        AvatarBlackPlayer.setSize(130,130);
        WinGameBlackPlayerPanel.add(nameBlack);
        nameBlack.setText(Player2.getName());
        nameBlack.setLocation(25,155);
        nameBlack.setSize(130,50);
        WinGameBlackPlayerPanel.setVisible(false);


        //Added Buttons and Listeners for BlackPlayer
        WinGameBlackPlayerPanel.add(HitBlack);
        HitBlack.setSize(120,30);
        HitBlack.setLocation(25,200);
        HitBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WinGameWhitePlayerPanel.setVisible(true);
                WinGameChessboardPanel.setLocation(170,0);
                WinGameChessboardPanel.setBackground(Color.lightGray);
                LogChat.append("Ходит " + Player1.getName() + " ...\n\r");
                WinGameBlackPlayerPanel.setVisible(false);
            }
        });


        WinGameBlackPlayerPanel.add(CancelHitBlack);
        CancelHitBlack.setSize(120,30);
        CancelHitBlack.setLocation(25,250);


        WinGameBlackPlayerPanel.add(BackMenuBlack);
        BackMenuBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane.showOptionDialog( WinCreateGameUI.this,"Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WinCreateGameUI.this,
                            "" + Player2.getName() + " проиграл!\n\r" +
                                    "Черные выиграли!\n\r" +
                                    "Рейтинг " + Player2.getName() + " : " + (Player1.getRating()-1) + "\n\r" +
                                    "Рейтинг " + Player1.getName() + " : " + (Player2.getRating()+1));
                    new WinMenuStartUI().setVisible(true);
                    setVisible(false);
                }
            }
        });
        BackMenuBlack.setSize(120,30);
        BackMenuBlack.setLocation(25,550);
    }


    private BufferedImage ImageBufferedIcon (String name){
        String Path = "./src/main/resources/";
        if (name.equals("backgroundChessBoard.jpg")){
            Path += "backgroundChessBoard.jpg";
        }else if (name.equals("avatarWhite")){
            Path += "whitePlayer.png";
        }else if (name.equals("avatarBlack")){
            Path += "blackPlayer.png";
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
