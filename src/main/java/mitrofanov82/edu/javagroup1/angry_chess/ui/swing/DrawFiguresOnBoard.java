package mitrofanov82.edu.javagroup1.angry_chess.ui.swing;

import mitrofanov82.edu.javagroup1.angry_chess.shared_model.FigureType;
import mitrofanov82.edu.javagroup1.angry_chess.shared_model.IGame;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DrawFiguresOnBoard extends JPanel {

    public DrawFiguresOnBoard(IGame game, SwingUI controler) {
        FigureType[][] gameFigures = game.getCurrentPosition();

        this.setBounds(58, 49, 500, 500);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLayout(new GridLayout(8, 8));
        this.setOpaque(false);
        this.setName("chessboard");

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                JLabel temp = new JLabel(new ImageIcon(ImagesUtils.getPathFigures(i, j, gameFigures)));
                temp.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        
                        Point point = e.getComponent().getLocation();
                        int width = (int) temp.getSize().getWidth();
                        int height = (int) temp.getSize().getHeight();
                        int x = (int) point.getX() / width;
                        int y = (int) point.getY() / height;
                        
                        System.out.println(x + "-" + y);
                        
                        if(!controler.figureIsChoise()) {
                            controler.addFrom(x, y);
                            controler.setFigureIsChoise(true);
                        }else {
                            if(!controler.moveIsChoise()) {
                                controler.addTo(x, y);
                                controler.setMoveIsChoise(true);
                            }
                        }
                        
                    }
                });

                this.add(temp);
            }
        }
    }
}
