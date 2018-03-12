package mitrofanov82.edu.javagroup1.angry_chess.ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IPlayer;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.ImagesUtils;

public class WindowGame extends JFrame {
    private JPanel spaceWindow = new JPanel();
    private WindowGame windowGame;
    private SwingUI controler;
    private IGame curentGame;
    
    private JLabel nameWhite = new JLabel();
    private JLabel nameBlack = new JLabel();
    
    private JLabel BackgroundChessboard = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("backgroundChessBoard.jpg")));
    private JLabel AvatarWhitePlayer = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatarWhite")));
    private JLabel AvatarBlackPlayer = new JLabel(new ImageIcon(ImagesUtils.ImageBufferedIcon("avatarBlack")));
    
    

    public WindowGame(SwingUI swingUI, IGame game) {
        super("Angry Chess - GAME");
        this.controler = swingUI;
        this.curentGame = game;
        windowGame = this;
        
        IPlayer firstPlayer = curentGame.getWhitePlayer();
        IPlayer secondPlayer = curentGame.getBlackPlayer();
        
        this.setTitle("Angry Chess - GAME ("+firstPlayer.getName() + " VS " + secondPlayer.getName()+")");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 640);
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.getContentPane().setLayout(null);
        
        
    }

}
