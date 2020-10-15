package exceptions;

public class FileDoesNotExist extends Exception {

    public FileDoesNotExist(String message) {
        super(message);
    }
}
