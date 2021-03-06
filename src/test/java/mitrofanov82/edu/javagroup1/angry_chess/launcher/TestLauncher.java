package mitrofanov82.edu.javagroup1.angry_chess.launcher;

import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModel;
import mitrofanov82.edu.javagroup1.angry_chess.model.ChessModelAPI;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.ChessPersistence;
import mitrofanov82.edu.javagroup1.angry_chess.persistence.IChessPersistenceAPI;
import mitrofanov82.edu.javagroup1.angry_chess.ui.swing.SwingUI;

public class TestLauncher {

    public static void main(String[] args) {
        IChessPersistenceAPI persistence = new ChessPersistence();
        ChessModelAPI model = new ChessModel();
        SwingUI ui = new SwingUI(persistence, model);
        ui.callWindowMenu();
    }

}
