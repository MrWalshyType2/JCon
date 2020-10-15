package commands;

import command_services.FileService;
import command_services.FolderService;
import commands.file_commands.CreateFileCommand;
import commands.file_commands.DeleteFileCommand;
import commands.file_commands.OpenFileCommand;
import commands.file_commands.WriteToFileCommand;
import commands.folder_commands.CreateFolderCommand;
import commands.folder_commands.DeleteFolderCommand;
import commands.folder_commands.ReadFolderCommand;

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
        commands.put("read-file", new OpenFileCommand(fileService));
        commands.put("read-folder", new ReadFolderCommand(folderService));
        commands.put("write-file", new WriteToFileCommand(fileService));
        commands.put("delete-file", new DeleteFileCommand(fileService));
        commands.put("delete-folder", new DeleteFolderCommand(folderService));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
