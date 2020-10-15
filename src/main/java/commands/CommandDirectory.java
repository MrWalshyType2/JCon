package commands;

import command_services.FileService;
import command_services.FolderService;
import commands.file_commands.CreateFileCommand;
import commands.file_commands.OpenFileCommand;
import commands.folder_commands.CreateFolderCommand;

import java.util.HashMap;

public class CommandDirectory {

    private HashMap<String, Command> commands;
    private FileService fileService;
    private FolderService folderService;

    public CommandDirectory() {
        commands = new HashMap<>();
        fileService = new FileService();
        folderService = new FolderService();

        commands.put("create-file", new CreateFileCommand(fileService));
        commands.put("create-folder", new CreateFolderCommand(folderService));
        commands.put("open-file", new OpenFileCommand(fileService));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
