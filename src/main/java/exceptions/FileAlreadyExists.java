package exceptions;

public class FileAlreadyExists extends Exception {
    public FileAlreadyExists(String message) {
        super(message);
    }
}
