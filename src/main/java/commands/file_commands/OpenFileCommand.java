package commands.file_commands;

import command_services.FileService;
import commands.Command;

public class OpenFileCommand implements Command {

    FileService fileService;

    public OpenFileCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute() {
        return fileService.open();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
