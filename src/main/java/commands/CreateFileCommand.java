package commands;

import command_services.FileService;

/**
 * Implementation of the Command API to create a file.
 */
public class CreateFileCommand implements Command {

    FileService file;

    public CreateFileCommand(FileService file) {
        this.file = file;
    }

    @Override
    public String execute() {
        return file.create();
    }
}
