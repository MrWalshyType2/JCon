import commands.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * An invoker for commands passed as a single argument.
 */
public class CommandInvoker {

    private final List<Command> commandHistory = new ArrayList<>();

    public String executeCommand(Command command) {
        commandHistory.add(command);
        return command.execute();
    }

    public String executeQuickCommand(Command command, String[] args) {
        commandHistory.add(command);
        return command.execute(args);
    }
}
