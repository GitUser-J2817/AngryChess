package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;

public class WindowGame extends JFrame {
    private WindowGame windowGame;
    private SwingUI controler;
    private IGame curentGame;

    private JPanel whitePlayerPanel = new JPanel();
    private JPanel blackPlayerPanel = new JPanel();
    private JPanel chessboardPanel = new JPanel();
    private JPanel figuresOnBoard = null;

    private Border etched = BorderFactory.createEtchedBorder();
    private Border titled = BorderFactory.createTitledBorder(etched);

    public WindowGame(SwingUI swingUI, IGame game) {
        super("Angry Chess - GAME");
        this.controler = swingUI;
        this.curentGame = game;
        windowGame = this;

        IPlayer firstPlayer = curentGame.getWhitePlayer();
        IPlayer secondPlayer = curentGame.getBlackPlayer();

        // *****************Configuration of window*********************
        this.setTitle("Angry Chess - GAME (" + firstPlayer.getName() + " VS " + secondPlayer.getName() + ")");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 640);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(null);

        // *********************Panel chessboard************************
        this.getContentPane().add(chessboardPanel);
        figuresOnBoard = new DrawFiguresOnBoard(curentGame, controler);
        createChessboardPanel();

        // **********************Panel log game*************************
        // TODO logChat
        JTextArea logChat = new JTextArea(9000, 20);
        JScrollPane Scroll = new JScrollPane(logChat);
        Scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        logChat.setAutoscrolls(true);
        logChat.setLocation(60, 535);
        logChat.setBackground(Color.white);
        logChat.setText("***Start NEW GAME " + firstPlayer.getName() + " VS " + secondPlayer.getName() + "***\n\r");
        logChat.append("Ходит " + firstPlayer.getName() + " ...\n\r");
        logChat.setCaretPosition(logChat.getDocument().getLength());
        logChat.setEditable(false);
        logChat.setSize(500, 50);
        logChat.setBorder(titled);

        // windowGame.add(LogChat);

        // ********************Panel White Player***********************
        whitePlayerPanel.setLayout(null);
        whitePlayerPanel.setBackground(Color.orange);
        whitePlayerPanel.setLocation(0, 0);
        whitePlayerPanel.setSize(170, 2000);

        JLabel avatarWhitePlayer = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatarWhite")));
        avatarWhitePlayer.setLocation(20, 20);
        avatarWhitePlayer.setSize(130, 130);
        whitePlayerPanel.add(avatarWhitePlayer);

        JLabel nameWhite = new JLabel();
        nameWhite.setText(firstPlayer.getName());
        nameWhite.setLocation(25, 155);
        nameWhite.setSize(130, 50);
        whitePlayerPanel.add(nameWhite);

        JButton hitWhite = new JButton("Походить");
        hitWhite.setSize(120, 30);
        hitWhite.setLocation(25, 200);
        whitePlayerPanel.add(hitWhite);

        JButton cancelHitWhite = new JButton("Отменить ход");
        cancelHitWhite.setSize(120, 30);
        cancelHitWhite.setLocation(25, 250);
        whitePlayerPanel.add(cancelHitWhite);

        JButton backMenuWhite = new JButton("Сдаться");
        backMenuWhite.setSize(120, 30);
        backMenuWhite.setLocation(25, 520);
        whitePlayerPanel.add(backMenuWhite);

        this.getContentPane().add(whitePlayerPanel);

        // ********************Panel Black Player***********************
        blackPlayerPanel.setLayout(null);
        blackPlayerPanel.setLocation(630, 0);
        blackPlayerPanel.setBackground(Color.yellow);
        blackPlayerPanel.setSize(170, 953);
        blackPlayerPanel.setVisible(false);

        JLabel avatarBlackPlayer = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatarBlack")));
        avatarBlackPlayer.setLocation(20, 20);
        avatarBlackPlayer.setSize(130, 130);
        blackPlayerPanel.add(avatarBlackPlayer);

        JLabel nameBlack = new JLabel();
        nameBlack.setText(secondPlayer.getName());
        nameBlack.setLocation(25, 155);
        nameBlack.setSize(130, 50);
        blackPlayerPanel.add(nameBlack);

        JButton hitBlack = new JButton("Походить");
        blackPlayerPanel.add(hitBlack);
        hitBlack.setSize(120, 30);
        hitBlack.setLocation(25, 200);

        JButton cancelHitBlack = new JButton("Отменить ход");
        blackPlayerPanel.add(cancelHitBlack);
        cancelHitBlack.setSize(120, 30);
        cancelHitBlack.setLocation(25, 250);

        JButton backMenuBlack = new JButton("Сдаться");
        backMenuBlack.setSize(120, 30);
        backMenuBlack.setLocation(25, 520);
        blackPlayerPanel.add(backMenuBlack);

        this.getContentPane().add(blackPlayerPanel);

        // **************************TEST MENU**************************
        this.setJMenuBar(createTestMenu());

        // *******************Listeners for White Player****************
        //
        // TODO Comment hitWhite.addMouseListener(new MouseAdapter(){})
        hitWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (controler.figureIsChoise() && controler.moveIsChoise()) {
                    curentGame = controler.makeMove(curentGame);

                    chessboardPanel.removeAll();
                    figuresOnBoard = new DrawFiguresOnBoard(curentGame, controler);
                    createChessboardPanel();

                    whitePlayerPanel.setVisible(false);
                    chessboardPanel.setLocation(0, 0);
                    // chessboardPanel.setBackground(Color.black);
                    logChat.append("Ходит " + secondPlayer.getName() + " ...\n\r");
                    blackPlayerPanel.setVisible(true);
                } else {
                    // TODO Ошибка не выбраности кординат
                    System.out.println("Ошибка не выбраности кординат");
                }

            }
        });

        // TODO Comment cancelHitWhite.addMouseListener(new MouseAdapter(){})
        cancelHitWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Flags FROM and TO set false");
                controler.setFigureIsChoise(false);
                controler.setMoveIsChoise(false);
            }
        });

        // TODO Comment backMenuWhite.addMouseListener(new MouseAdapter(){})
        backMenuWhite.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane.showOptionDialog(WindowGame.this, "Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WindowGame.this,
                            "" + firstPlayer.getName() + " проиграл!\n\r" + "Черные выиграли!\n\r" + "Рейтинг "
                                    + firstPlayer.getName() + " : " + (firstPlayer.getRating() - 1) + "\n\r"
                                    + "Рейтинг " + secondPlayer.getName() + " : " + (secondPlayer.getRating() + 1));
                    controler.callWindowMenu();
                    windowGame.setVisible(false);
                }
            }
        });

        // *******************Listeners for Black Player****************
        //
        // TODO Comment hitBlack.addMouseListener(new MouseAdapter(){})
        hitBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (controler.figureIsChoise() && controler.moveIsChoise()) {
                    curentGame = controler.makeMove(curentGame);

                    chessboardPanel.removeAll();
                    figuresOnBoard = new DrawFiguresOnBoard(curentGame, controler);
                    createChessboardPanel();

                    whitePlayerPanel.setVisible(true);
                    chessboardPanel.setLocation(170, 0);
                    // chessboardPanel.setBackground(Color.lightGray);
                    logChat.append("Ходит " + firstPlayer.getName() + " ...\n\r");
                    blackPlayerPanel.setVisible(false);
                } else {
                    // TODO Ошибка не выбраности кординат
                    System.out.println("Ошибка не выбраности кординат");
                }

            }
        });

        // TODO Comment cancelHitBlack.addMouseListener(new MouseAdapter(){})
        cancelHitBlack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Flags FROM and TO set false");
                controler.setFigureIsChoise(false);
                controler.setMoveIsChoise(false);
            }
        });

        // TODO Comment backMenuBlack.addMouseListener(new MouseAdapter(){})
        backMenuBlack.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                Object[] options = { "Да", "Нет!" };
                int n = JOptionPane.showOptionDialog(WindowGame.this, "Ты уверен, что хочешь сдаться?",
                        "Это провал! Сдаешься?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options,
                        options[0]);
                if (n == 0) {
                    JOptionPane.showMessageDialog(WindowGame.this,
                            "" + secondPlayer.getName() + " проиграл!\n\r" + "Белые выиграли!\n\r" + "Рейтинг "
                                    + secondPlayer.getName() + " : " + (secondPlayer.getRating() - 1) + "\n\r"
                                    + "Рейтинг " + firstPlayer.getName() + " : " + (firstPlayer.getRating() + 1));
                    controler.callWindowMenu();
                    windowGame.setVisible(false);
                }
            }
        });

    }

    /*
     * TODO Doc createChessboardPanel()
     */
    private void createChessboardPanel() {
        chessboardPanel.setLayout(null);
        chessboardPanel.setBackground(Color.lightGray);
        chessboardPanel.setLocation(170, 0);
        chessboardPanel.setSize(630, 610);

        JPanel glassBoard = new JPanel();
        glassBoard.setOpaque(false);

        JPanel fullBoard = new JPanel();
        fullBoard.setLayout(null);
        fullBoard.setBounds(36, 28, 544, 542);

        String liters = "                  A                  B                  C                  D                  E                  F                  G                  H";
        String numbers = "<html>1<br><br><br><br>2<br><br><br><br>3<br><br><br><br>4<br><br><br><br>5<br><br><br><br>6<br><br><br><br>7<br><br><br><br>8</html>";

        JLabel numbTop = new JLabel(liters);
        numbTop.setBounds(0, 0, 544, 21);
        fullBoard.add(numbTop);

        JLabel numbBottom = new JLabel(liters);
        numbBottom.setBounds(0, 518, 544, 24);
        fullBoard.add(numbBottom);

        JLabel numbRight = new JLabel(numbers);
        numbRight.setHorizontalTextPosition(SwingConstants.LEADING);
        numbRight.setBounds(530, 0, 14, 539);
        fullBoard.add(numbRight);

        JLabel numbLeft = new JLabel(numbers);
        numbLeft.setHorizontalTextPosition(SwingConstants.LEADING);
        numbLeft.setBounds(10, 0, 14, 539);
        fullBoard.add(numbLeft);

        JLabel backgroundChessboard = new JLabel(
                new ImageIcon(ImagesUtils.ImageBufferedIcon("backgroundChessBoard.jpg")));
        backgroundChessboard.setBounds(22, 21, 500, 500);

        chessboardPanel.add(figuresOnBoard);
        backgroundChessboard.setBorder(titled);
        fullBoard.add(backgroundChessboard);
        chessboardPanel.add(fullBoard);
    }

    /*
     * TODO Doc createTestMenu()
     */
    private JMenuBar createTestMenu() {

        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Админка");
        menuBar.add(menu);

        JMenu menu_2 = new JMenu("Сдаться");
        menu.add(menu_2);

        JMenuItem menuItem_3 = new JMenuItem("Белые");
        menu_2.add(menuItem_3);
        menuItem_3.addMouseListener(new MouseAdapter() {
            // TODO Меню.Сдаться.Белые
        });

        JMenuItem menuItem_4 = new JMenuItem("Черные");
        menu_2.add(menuItem_4);
        menuItem_4.addMouseListener(new MouseAdapter() {
            // TODO Меню.Сдаться.Черные
        });

        JMenu menu_3 = new JMenu("Мат");
        menu.add(menu_3);

        JMenuItem menuItem = new JMenuItem("Белые");
        menu_3.add(menuItem);
        menuItem.addMouseListener(new MouseAdapter() {
            // TODO Меню.Мат.Белые
        });

        JMenuItem menuItem_5 = new JMenuItem("Черные");
        menu_3.add(menuItem_5);
        menuItem_5.addMouseListener(new MouseAdapter() {
         // TODO Меню.Мат.Черные
        });

        JMenu menu_1 = new JMenu("Шах");
        menu.add(menu_1);

        JMenuItem menuItem_1 = new JMenuItem("Белые");
        menu_1.add(menuItem_1);
        menuItem_1.addMouseListener(new MouseAdapter() {
            // TODO Меню.Шах.Белые
        });

        JMenuItem menuItem_2 = new JMenuItem("Черные");
        menu_1.add(menuItem_2);
        menuItem_2.addMouseListener(new MouseAdapter() {
            // TODO Меню.Шах.Черные
        });

        JMenuItem menuItem_6 = new JMenuItem("Выход");
        menuItem_6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.exit(0);
            }
        });
        menu.add(menuItem_6);

        return menuBar;
    }

}
