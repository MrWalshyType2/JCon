package exceptions;

public class CommandDoesNotExist extends Exception {

    public CommandDoesNotExist(String message) {
        super(message);
    }
}
