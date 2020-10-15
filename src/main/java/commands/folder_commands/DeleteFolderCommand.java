package commands.folder_commands;

import command_services.FolderService;
import commands.Command;

public class DeleteFolderCommand implements Command {

    private FolderService folderService;

    public DeleteFolderCommand(FolderService folderService) {
        this.folderService = folderService;
    }
    @Override
    public String execute() {
        return folderService.delete();
    }

    @Override
    public String execute(String[] args) {
        return folderService.quickDelete(args);
    }
}
