package commands.file_commands;

import command_services.FileService;
import commands.Command;

public class WriteToFileCommand implements Command {

    FileService fileService;

    public WriteToFileCommand(FileService fileService) {
        this.fileService = fileService;
    }

    @Override
    public String execute() {
        return fileService.write();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
