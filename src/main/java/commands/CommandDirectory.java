package commands;

import command_services.FileService;

import java.util.HashMap;

public class CommandDirectory {

    private HashMap<String, Command> commands;
    private FileService fileService;

    public CommandDirectory() {
        commands = new HashMap<>();
        fileService = new FileService();

        commands.put("create-file", new CreateFileCommand(fileService));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
