package commands.file_commands;

import command_services.FileService;
import commands.Command;

public class DeleteFileCommand implements Command {

    private FileService fileService;

    public DeleteFileCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute() {
        return fileService.delete();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
