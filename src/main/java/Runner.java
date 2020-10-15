import command_services.FileService;
import commands.Command;
import commands.CommandDirectory;
import commands.CreateFileCommand;
import commands.OpenFileCommand;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Runner {

    public static void main(String args[]) {
        HashMap<String, Command> commands = new CommandDirectory().getCommands();

        SingleCommandInvoker singleInvoker = new SingleCommandInvoker();
//        String res = singleInvoker.executeCommand(new CreateFileCommand(new FileService()));
        String res = singleInvoker.executeCommand(commands.get("create-file"));
        System.out.println(res);
    }
}
