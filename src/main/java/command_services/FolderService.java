package command_services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.logging.Logger;

public class FolderService {

    private final Logger LOGGER = Logger.getLogger(FolderService.class.getName());
    private final Scanner SCANNER = new Scanner(System.in);

    Path path;

    public String create() {
        try {
            LOGGER.info("Please enter a path with the dir to create:");
            path = Paths.get(SCANNER.nextLine());
            Files.createDirectory(path);
            return "Folder created successfully!\nPATH: " + path.toString();
        } catch (IOException e) {
            return e.getMessage();
        }

    }
}
