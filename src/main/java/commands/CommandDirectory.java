package commands;

import command_services.FileService;

import java.util.HashMap;

public class CommandDirectory {

    private HashMap<String, Command> commands = new HashMap<>();

    public CommandDirectory() {
        commands.put("create-file", new CreateFileCommand(new FileService()));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
