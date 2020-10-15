package commands;

import command_services.FileService;

public class QuickCreateFileCommand implements QuickCommand {

    FileService file;

    public QuickCreateFileCommand(FileService file) {
        this.file = file;
    }

    @Override
    public String execute(String[] args) {
        return file.quickCreate(args);
    }

    @Override
    public String execute() {
        return null;
    }
}
