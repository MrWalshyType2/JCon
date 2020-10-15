package command_services;

import exceptions.CommandDoesNotExist;
import exceptions.FileAlreadyExists;
import exceptions.FileDoesNotExist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;

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

    public String quickOpen(String[] args) {
        try {
            file = new File(args[1]);
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

    public String write() {
        try {
            FileWriter fileWriter;
            LOGGER.info("Please enter the file name that you would like to write to:");
            String fileName = SCANNER.nextLine();
            String fileNameArgs = "test " + fileName;
            String[] args = fileNameArgs.split(" ");

            LOGGER.info("Complete rewrite or append?");
            String command = SCANNER.nextLine();

            if (command.equalsIgnoreCase("rewrite")) fileWriter = new FileWriter(fileName, false);
            else if (command.equalsIgnoreCase("append")) fileWriter = new FileWriter(fileName, true);
            else throw new CommandDoesNotExist("File mode '" + command + "' does not exist for file writing.");

            LOGGER.info("Enter the contents to be written:");
            String contents = SCANNER.nextLine();
            fileWriter.write("\n" + contents);
            fileWriter.close();
            return quickOpen(args);
        } catch (IOException | CommandDoesNotExist e) {
            return e.getMessage();
        }
    }

    public String quickWrite(String[] args) {
        try {
            String fileName = args[1];
            String fileMode = args[2];
            String contents = Arrays.stream(args).filter(x -> x != fileName)
                                                 .filter(x -> x != fileMode)
                                                 .filter(x -> x != args[0])
                                                 .collect(Collectors.joining(" "));
            FileWriter fileWriter;

            if (fileMode.equalsIgnoreCase("rewrite")) fileWriter = new FileWriter(fileName, false);
            else if (fileMode.equalsIgnoreCase("append")) fileWriter = new FileWriter(fileName, true);
            else throw new CommandDoesNotExist("File mode '" + fileMode + "' does not exist for file writing.");

            fileWriter.write("\n" + contents);
            fileWriter.close();
            return quickOpen(args);
        } catch (IOException | CommandDoesNotExist e) {
            return e.getMessage();
        }
    }

    public String delete() {
        try {
            LOGGER.info("Please enter the file name to delete:");
            file = new File(SCANNER.nextLine());
            if (file.delete()) return "Deleted file: " + file.getAbsolutePath();
            else throw new FileDoesNotExist("File does not exist to delete");
        } catch (FileDoesNotExist fileDoesNotExist) {
            return fileDoesNotExist.getMessage();
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
