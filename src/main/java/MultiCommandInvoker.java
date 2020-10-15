import commands.Command;
import commands.QuickCommand;

import java.util.ArrayList;
import java.util.List;

public class MultiCommandInvoker {

    private final List<QuickCommand> commandHistory = new ArrayList<>();

    public String executeCommand(QuickCommand command, String args[]) {
        commandHistory.add(command);
        return command.execute(args);
    }
}
