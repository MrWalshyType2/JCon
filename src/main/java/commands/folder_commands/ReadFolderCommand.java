package commands.folder_commands;

import command_services.FolderService;
import commands.Command;

public class ReadFolderCommand implements Command {

    private FolderService folderService;

    public ReadFolderCommand(FolderService folderService) {
        this.folderService = folderService;
    }

    @Override
    public String execute() {
        return folderService.read();
    }

    @Override
    public String execute(String[] args) {
        return folderService.quickRead(args);
    }
}
