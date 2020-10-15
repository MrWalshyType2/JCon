package commands.file_commands;

import command_services.FileService;
import commands.Command;

public class OpenFileCommand implements Command {

    FileService file;

    @Override
    public String execute() {
        return file.open();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
