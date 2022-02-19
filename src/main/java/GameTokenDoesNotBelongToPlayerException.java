public class GameTokenDoesNotBelongToPlayerException extends Exception {
    public GameTokenDoesNotBelongToPlayerException() {
    }

    public GameTokenDoesNotBelongToPlayerException(String message) {
        super(message);
    }
}
