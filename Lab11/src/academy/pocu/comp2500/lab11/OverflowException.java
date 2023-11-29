package academy.pocu.comp2500.lab11;

public class OverflowException extends RuntimeException {
    //private String message;
    private static final long serialVersionUID = 3L;
    public OverflowException(final String msg) {
        super(msg);
    }
}
