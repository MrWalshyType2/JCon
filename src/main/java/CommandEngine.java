import command_services.FileService;
import commands.Command;
import commands.CommandDirectory;

import java.util.HashMap;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommandEngine {

    private HashMap<String, Command> commands;
    private CommandInvoker singleInvoker;

    private Logger LOGGER = Logger.getLogger(FileService.class.getName());
    private Scanner SCANNER = new Scanner(System.in);

    public CommandEngine() {
        commands = new CommandDirectory().getCommands();
        singleInvoker = new CommandInvoker();
    }

    public void run() {
        String[] command;
        String res;

        while (true) {
            LOGGER.info("PLEASE ENTER A COMMAND: ");
            command = SCANNER.nextLine().split(" ");

            if (command[0].equalsIgnoreCase("exit") || command[0].equalsIgnoreCase("e")) System.exit(0);

            try {
                if (command.length == 1) {
                    res = singleInvoker.executeCommand(commands.get(command[0]));
                } else {
                    res = singleInvoker.executeQuickCommand(commands.get(command[0]), command);
                }
                LOGGER.info(res);
            } catch (NullPointerException e) {
                LOGGER.warning("Command '" + command[0] + "' does not exist!");
            }
        }
    }
}
