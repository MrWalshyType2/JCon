package command_services;

import exceptions.FileAlreadyExists;
import exceptions.FileDoesNotExist;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Receiver object for file related requests.
 */
public class FileService {

    Logger logger = Logger.getLogger(FileService.class.getName());
    Scanner scanner = new Scanner(System.in);

    private File file;

    public String create() {
        try {
            logger.info("Please enter a name for your file:");
            String name = scanner.nextLine();
            file = new File(name);

            if (file.createNewFile()) {
                return getFileInfo();
            } else {
                throw new FileAlreadyExists("File with name " + file.getName() + " already exists!");
            }
        } catch (IOException | FileAlreadyExists | FileDoesNotExist e) {
            return e.getMessage();
        }

    }

    public String open() {
        return "Opened file: ";
    }

    private String getFileInfo() throws FileDoesNotExist {
        if (file.exists()) {
            return "FILE NAME: " + file.getName() + "\n" +
                    "ABSOLUTE PATH: " + file.getAbsolutePath() + "\n" +
                    "WRITEABLE: " + file.canWrite() + "\n" +
                    "READABLE: " + file.canRead() + "\n" +
                    "FILE SIZE (BYTES): " + file.length();
        } else {
            throw new FileDoesNotExist("File with name " + file.getName() + " does not exist!");
        }
    }
}
