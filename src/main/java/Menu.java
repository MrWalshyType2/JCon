import commands.Command;
import commands.CommandDirectory;

import java.util.HashMap;

public class Menu {

    private HashMap<String, Command> commands;
    private SingleCommandInvoker singleInvoker;

    public Menu() {
        commands = new CommandDirectory().getCommands();
        singleInvoker = new SingleCommandInvoker();
    }

    public void run() {
        String res = singleInvoker.executeCommand(commands.get("create-file"));
        System.out.println(res);
    }
}
