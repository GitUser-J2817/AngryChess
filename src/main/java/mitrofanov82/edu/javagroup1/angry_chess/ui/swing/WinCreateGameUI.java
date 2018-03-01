package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.model.ModelFacade;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.Coord;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class WinCreateGameUI extends JFrame {
    private JLabel nameWhite = new JLabel();
    private JLabel nameBlack = new JLabel();
    private JLabel BackgroundChessboard = new JLabel(
            new ImageIcon("D:\\Java\\AngryChess\\src\\main\\resources\\backgroundChessBoard.jpg"));
    private JLabel AvatarWhitePlayer = new JLabel(new ImageIcon(ImageBufferedIcon("avatarWhite")));
    private JLabel AvatarBlackPlayer = new JLabel(new ImageIcon(ImageBufferedIcon("avatarBlack")));
    private JTextArea LogChat = new JTextArea(9000, 20);
    private JButton BackMenuWhite = new JButton("Сдаться");
    private JButton BackMenuBlack = new JButton("Сдаться");
    private JButton HitWhite = new JButton("Походить");
    private JButton CancelHitWhite = new JButton("Отменить ход");
    private JButton HitBlack = new JButton("Походить");
    private JButton CancelHitBlack = new JButton("Отменить ход");
    private JPanel WinGameWhitePlayerPanel = new JPanel();
    private JPanel WinGameBlackPlayerPanel = new JPanel();
    private JPanel WinGameChessboardPanel = new JPanel();
    private JPanel GlassBoard = new JPanel();
    private BufferedImage image = null;
    private Border etched = BorderFactory.createEtchedBorder();
    private Border titled = BorderFactory.createTitledBorder(etched);
    String text = "<html>1<br><br><br><br>2<br><br><br><br>3<br><br><br><br>4<br><br><br><br>5<br><br><br><br>6<br><br><br><br>7<br><br><br><br>8</html>";
    private final JLabel BoardNumbRight = new JLabel(text);
    private final JMenuBar menuBar = new JMenuBar();


    WinCreateGameUI(CreatedPlayers Player1, CreatedPlayers Player2) {
        super("Game: " + Player1.getName() + " VS " + Player2.getName());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 640);
        setMinimumSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setResizable(true);
        getContentPane().setLayout(null);

        // Panel Chessboard
        getContentPane().add(WinGameChessboardPanel);
        WinGameChessboardPanel.setLayout(null);
        WinGameChessboardPanel.setBackground(Color.lightGray);
        WinGameChessboardPanel.setLocation(170, 0);
        WinGameChessboardPanel.setSize(630, 610);
        GlassBoard.setOpaque(false);


        WinGameChessboardPanel.add(new ParsNowBoard());
        /*ChessBoard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane.showOptionDialog(WinCreateGameUI.this, "Ты точно нажал что-то?",
                        "Это провал! Сработало или нет?!:)", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    if (event.getX() < 63 && event.getY() < 63) {
                        JOptionPane.showMessageDialog(WinCreateGameUI.this,
                                "Крутец, ты нажал на А-1 \n\r" +
                                         "x: " + event.getX() + "\n\r" +
                                            "y: " + event.getY());
                    }else if(event.getX()>63 && event.getX()<123 && event.getY()<63){
                        JOptionPane.showMessageDialog(WinCreateGameUI.this,
                                "Крутец, ты нажал на B-1 \n\r" +
                                        "x: " + event.getX() + "\n\r" +
                                        "y: " + event.getY());
                    }
                }
            }

            @Override
            public void mousePressed(MouseEvent event) {
            }

            @Override
            public void mouseReleased(MouseEvent event) {
            }

        });
        ChessBoard.setOpaque(false);
        ChessBoard.setBounds(58, 49, 500, 500);
        WinGameChessboardPanel.add(ChessBoard);
        ChessBoard.setLayout(null);*/


        JPanel FullBoard = new JPanel();
        FullBoard.setLayout(null);
        FullBoard.setBounds(36, 28, 544, 542);
        WinGameChessboardPanel.add(FullBoard);

        JLabel BoardABCtop = new JLabel(
                "                  A                  B                  C                  D                  E                  F                  G                  H");
        BoardABCtop.setBounds(0, 0, 544, 21);
        FullBoard.add(BoardABCtop);

        JLabel BoardNumbBottom = new JLabel(
                "                  A                  B                  C                  D                  E                  F                  G                  H");
        BoardNumbBottom.setBounds(0, 518, 544, 24);
        FullBoard.add(BoardNumbBottom);
        BoardNumbRight.setHorizontalTextPosition(SwingConstants.LEADING);
        BoardNumbRight.setBounds(530, 0, 14, 539);

        FullBoard.add(BoardNumbRight);

        JLabel BoardNumbLeft = new JLabel(
                "<html>1<br><br><br><br>2<br><br><br><br>3<br><br><br><br>4<br><br><br><br>5<br><br><br><br>6<br><br><br><br>7<br><br><br><br>8</html>");
        BoardNumbLeft.setHorizontalTextPosition(SwingConstants.LEADING);
        BoardNumbLeft.setBounds(10, 0, 14, 539);
        FullBoard.add(BoardNumbLeft);
        BackgroundChessboard.setBounds(22, 21, 500, 500);
        FullBoard.add(BackgroundChessboard);
        BackgroundChessboard.setBorder(titled);
        // Добавить реализацию ЛогЧата ***
        JScrollPane Scroll = new JScrollPane(LogChat);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        // LogChat.setAutoscrolls(true);
        // WinGameChessboardPanel.add(LogChat);
        LogChat.setLocation(60, 535);
        LogChat.setBackground(Color.white);
        LogChat.setText("***Start NEW GAME " + Player1.getName() + " VS " + Player2.getName() + "***\n\r");
        LogChat.append("РҐРѕРґРёС‚ " + Player1.getName() + " ...\n\r");
        LogChat.setCaretPosition(LogChat.getDocument().getLength());
        LogChat.setEditable(false);
        LogChat.setSize(500, 50);
        LogChat.setBorder(titled);

        // Panel WhitePlayer
        getContentPane().add(WinGameWhitePlayerPanel);
        WinGameWhitePlayerPanel.setLayout(null);
        WinGameWhitePlayerPanel.setBackground(Color.orange);
        WinGameWhitePlayerPanel.setLocation(0, 0);
        WinGameWhitePlayerPanel.setSize(170, 2000);
        WinGameWhitePlayerPanel.add(AvatarWhitePlayer);
        AvatarWhitePlayer.setLocation(20, 20);
        AvatarWhitePlayer.setSize(130, 130);
        WinGameWhitePlayerPanel.add(nameWhite);
        nameWhite.setText(Player1.getName());
        nameWhite.setLocation(25, 155);
        nameWhite.setSize(130, 50);

        // Added Buttons and Listeners for WhitePlayer
        WinGameWhitePlayerPanel.add(HitWhite);
        HitWhite.setSize(120, 30);
        HitWhite.setLocation(25, 200);
        HitWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WinGameWhitePlayerPanel.setVisible(false);
                WinGameChessboardPanel.setLocation(0, 0);
                WinGameChessboardPanel.setBackground(Color.black);
                LogChat.append("{Ходит " + Player2.getName() + " ...\n\r");
                WinGameBlackPlayerPanel.setVisible(true);
            }
        });

        WinGameWhitePlayerPanel.add(CancelHitWhite);
        CancelHitWhite.setSize(120, 30);
        CancelHitWhite.setLocation(25, 250);

        WinGameWhitePlayerPanel.add(BackMenuWhite);
        BackMenuWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane.showOptionDialog(WinCreateGameUI.this, "Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WinCreateGameUI.this,
                            "" + Player1.getName() + " проиграл!\n\r" + "Черные выиграли!\n\r" + "Рейтинг "
                                    + Player1.getName() + " : " + (Player1.getRating() - 1) + "\n\r" + "Рейтинг "
                                    + Player2.getName() + " : " + (Player2.getRating() + 1));
                    new WinMenuStartUI().setVisible(true);
                    setVisible(false);
                }
            }
        });
        BackMenuWhite.setSize(120, 30);
        BackMenuWhite.setLocation(25, 520);

        // Panel BlackPlayer
        WinGameBlackPlayerPanel.setLayout(null);
        WinGameBlackPlayerPanel.setLocation(630, 0);
        WinGameBlackPlayerPanel.setBackground(Color.yellow);
        getContentPane().add(WinGameBlackPlayerPanel);
        WinGameBlackPlayerPanel.setSize(170, 953);
        WinGameBlackPlayerPanel.add(AvatarBlackPlayer);
        AvatarBlackPlayer.setLocation(20, 20);
        AvatarBlackPlayer.setSize(130, 130);
        WinGameBlackPlayerPanel.add(nameBlack);
        nameBlack.setText(Player2.getName());
        nameBlack.setLocation(25, 155);
        nameBlack.setSize(130, 50);
        WinGameBlackPlayerPanel.setVisible(false);

        // Added Buttons and Listeners for BlackPlayer
        WinGameBlackPlayerPanel.add(HitBlack);
        HitBlack.setSize(120, 30);
        HitBlack.setLocation(25, 200);
        HitBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                WinGameWhitePlayerPanel.setVisible(true);
                WinGameChessboardPanel.setLocation(170, 0);
                WinGameChessboardPanel.setBackground(Color.lightGray);
                LogChat.append("РҐРѕРґРёС‚ " + Player1.getName() + " ...\n\r");
                WinGameBlackPlayerPanel.setVisible(false);
            }
        });

        WinGameBlackPlayerPanel.add(CancelHitBlack);
        CancelHitBlack.setSize(120, 30);
        CancelHitBlack.setLocation(25, 250);

        WinGameBlackPlayerPanel.add(BackMenuBlack);
        BackMenuBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = {"Да", "Нет!"};
                int n = JOptionPane.showOptionDialog(WinCreateGameUI.this, "Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WinCreateGameUI.this,
                            "" + Player2.getName() + " проиграл!\n\r" + "Черные выиграли!\n\r" + "Рейтинг "
                                    + Player2.getName() + " : " + (Player1.getRating() - 1) + "\n\r" + "Рейтинг "
                                    + Player1.getName() + " : " + (Player2.getRating() + 1));
                    new WinMenuStartUI().setVisible(true);
                    setVisible(false);
                }
            }
        });
        BackMenuBlack.setSize(120, 30);
        BackMenuBlack.setLocation(25, 520);

        setJMenuBar(menuBar);
        JMenu menu = new JMenu("Админка");
        menuBar.add(menu);
        JMenu menu_2 = new JMenu("Сдаться");
        menu.add(menu_2);
        JMenuItem menuItem_3 = new JMenuItem("Белые");
        menu_2.add(menuItem_3);
        JMenuItem menuItem_4 = new JMenuItem("Черные");
        menu_2.add(menuItem_4);
        JMenu menu_3 = new JMenu("Мат");
        menu.add(menu_3);
        JMenuItem menuItem = new JMenuItem("Белые");
        menu_3.add(menuItem);
        JMenuItem menuItem_5 = new JMenuItem("Черные");
        menu_3.add(menuItem_5);
        JMenu menu_1 = new JMenu("Шах");
        menu.add(menu_1);
        JMenuItem menuItem_1 = new JMenuItem("Белые");
        menu_1.add(menuItem_1);
        JMenuItem menuItem_2 = new JMenuItem("Черные");
        menu_1.add(menuItem_2);
        JMenuItem menuItem_6 = new JMenuItem("Выход");
        menuItem_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem_6);
    }

    private BufferedImage ImageBufferedIcon(String name) {
        String Path = "./src/main/resources/";
        if (name.equals("backgroundChessBoard.jpg")) {
            Path += "backgroundChessBoard.jpg";
        } else if (name.equals("avatarWhite")) {
            Path += "whitePlayer.png";
        } else if (name.equals("avatarBlack")) {
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
