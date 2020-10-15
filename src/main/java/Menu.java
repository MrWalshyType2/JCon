import command_services.FileService;
import commands.Command;
import commands.CommandDirectory;

import java.util.HashMap;
import java.util.logging.Logger;

public class Menu {

    private HashMap<String, Command> commands;
    private CommandInvoker singleInvoker;

    private Logger logger = Logger.getLogger(FileService.class.getName());

    public Menu() {
        commands = new CommandDirectory().getCommands();
        singleInvoker = new CommandInvoker();
    }

    public void run() {
        String input = "create-file";
        String[] command = input.split(" ");
        String res;

        if (command.length == 1) {
            res = singleInvoker.executeCommand(commands.get(command[0]));
        } else {
            res = singleInvoker.executeQuickCommand(commands.get(command[0]), command);
        }
        System.out.println(res);

//        while (true) {
//            logger.info("PLEASE ENTER A COMMAND: ");
//        }
    }
}
