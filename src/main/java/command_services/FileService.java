package command_services;

import exceptions.FileAlreadyExists;
import exceptions.FileDoesNotExist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Logger;

/**
 * Receiver object for file related requests.
 */
public class FileService {

    private final Logger LOGGER = Logger.getLogger(FileService.class.getName());
    private final Scanner SCANNER = new Scanner(System.in);

    private File file;

    public String create() {
        try {
            LOGGER.info("Please enter a name (including path, abs or rel) for your file:");
            String name = SCANNER.nextLine();
            file = new File(name);

            if (file.createNewFile()) return getFileInfo();
            else throw new FileAlreadyExists("File with name " + file.getName() + " already exists!");
        } catch (IOException | FileAlreadyExists | FileDoesNotExist e) {
            return e.getMessage();
        }
    }

    public String quickCreate(String args[]) {
        try {
            String name = args[1];
            file = new File(name);
            if (file.createNewFile()) return getFileInfo();
            else throw new FileAlreadyExists("File with name " + file.getName() + " already exists!");
        } catch (IOException | FileDoesNotExist | FileAlreadyExists e) {
            return e.getMessage();
        }
    }

    public String open() {
        try {
            LOGGER.info("Please enter a name (including path, abs or rel) for the file to open:");
            file = new File(SCANNER.nextLine());
            Scanner fileReader = new Scanner(file);
            String fileContents = "";

            while (fileReader.hasNextLine()) {
                fileContents += fileReader.nextLine() + "\n";
            }
            return fileContents;
        } catch (FileNotFoundException e) {
            return e.getMessage();
        }
    }

    private String getFileInfo() throws FileDoesNotExist {
        if (file.exists()) {
            return "\nFILE NAME: " + file.getName() + "\n" +
                    "ABSOLUTE PATH: " + file.getAbsolutePath() + "\n" +
                    "WRITEABLE: " + file.canWrite() + "\n" +
                    "READABLE: " + file.canRead() + "\n" +
                    "FILE SIZE (BYTES): " + file.length() + "\n";
        } else {
            throw new FileDoesNotExist("File with name " + file.getName() + " does not exist!");
        }
    }
}
