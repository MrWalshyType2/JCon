package commands.folder_commands;

import command_services.FolderService;
import commands.Command;

public class CreateFolderCommand implements Command {

    FolderService folderService;

    public CreateFolderCommand(FolderService folderService) {
        this.folderService = folderService;
    }

    @Override
    public String execute() {
        return null;
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
