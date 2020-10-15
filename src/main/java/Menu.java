import commands.Command;
import commands.CommandDirectory;
import commands.QuickCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Menu {

    private HashMap<String, Command> commands;
    private SingleCommandInvoker singleInvoker;
    private MultiCommandInvoker multiInvoker;

    public Menu() {
        commands = new CommandDirectory().getCommands();
        singleInvoker = new SingleCommandInvoker();
        multiInvoker = new MultiCommandInvoker();
    }

    public void run() {
//        String res = singleInvoker.executeCommand(commands.get("create-file"));
//        System.out.println(res);

        String[] args = new ArrayList<String>().toArray(new String[3]);
        args[0] = "hello.txt";

        String res2 = multiInvoker.executeCommand((QuickCommand) commands.get("file"), args);
        System.out.println(res2);
    }
}
