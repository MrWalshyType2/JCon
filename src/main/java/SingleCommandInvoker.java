import commands.Command;

import java.util.ArrayList;
import java.util.List;

/**
 * An invoker for commands passed as a single argument.
 */
public class SingleCommandInvoker {

    private final List<Command> commandHistory = new ArrayList<>();

    public String executeCommand(Command command) {
        commandHistory.add(command);
        return command.execute();
    }
}
