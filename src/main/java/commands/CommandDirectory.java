package commands;

import command_services.FileService;
import command_services.FolderService;
import command_services.HttpService;
import commands.file_commands.CreateFileCommand;
import commands.file_commands.DeleteFileCommand;
import commands.file_commands.OpenFileCommand;
import commands.file_commands.WriteToFileCommand;
import commands.folder_commands.CreateFolderCommand;
import commands.folder_commands.DeleteFolderCommand;
import commands.folder_commands.ReadFolderCommand;
import commands.http_commands.GetRequestCommand;

import java.util.HashMap;

public class CommandDirectory {

    private HashMap<String, Command> commands;
    private FileService fileService;
    private FolderService folderService;
    private HttpService httpService;

    public CommandDirectory() {
        commands = new HashMap<>();
        fileService = new FileService();
        folderService = new FolderService();
        httpService = new HttpService();

        commands.put("create-file", new CreateFileCommand(fileService));
        commands.put("create-folder", new CreateFolderCommand(folderService));
        commands.put("read-file", new OpenFileCommand(fileService));
        commands.put("read-folder", new ReadFolderCommand(folderService));
        commands.put("write-file", new WriteToFileCommand(fileService));
        commands.put("delete-file", new DeleteFileCommand(fileService));
        commands.put("delete-folder", new DeleteFolderCommand(folderService));
        commands.put("get", new GetRequestCommand(httpService));
    }

    public HashMap<String, Command> getCommands() {
        return commands;
    }

    public void setCommands(HashMap<String, Command> commands) {
        this.commands = commands;
    }
}
