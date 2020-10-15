package command_services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FolderService {

    private final Logger LOGGER = Logger.getLogger(FolderService.class.getName());
    private final Scanner SCANNER = new Scanner(System.in);

    Path path;

    public String create() {
        try {
            LOGGER.info("Please enter a path with the dir to create:");
            path = Paths.get(SCANNER.nextLine());
            path = Files.createDirectory(path);
            return "Folder created successfully!\nPATH: " + path.toString() + "\n";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String quickCreate(String[] args) {
        try {
            path = Paths.get(args[1]);
            path = Files.createDirectory(path);
            return "Folder created successfully!\nPATH: " + path.toString() + "\n";
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String read() {
        LOGGER.info("Please enter a path with the dir to be read:");
        path = Paths.get(SCANNER.nextLine());
        try (Stream<Path> walk = Files.walk(path)) {
            List<String> results = walk.filter(Files::isRegularFile)
                                       .map(r -> r.toString()).collect(Collectors.toList());

            String result = results.stream().collect(Collectors.joining("\n"));
            return result;
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public String quickRead(String[] args) {
        path = Paths.get(args[1]);
        try (Stream<Path> walk = Files.walk(path)) {
            List<String> results = walk.filter(Files::isRegularFile)
                    .map(r -> r.toString()).collect(Collectors.toList());

            String result = results.stream().collect(Collectors.joining("\n"));
            return result;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
