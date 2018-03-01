package mitrofanov82.edu.javagroup1.angry_chess.shared_model.exceptions;

@SuppressWarnings("serial")
public class IncorrectMoveException extends ChessModelException {

    public IncorrectMoveException(String message) {
        super(message);
    }

}
