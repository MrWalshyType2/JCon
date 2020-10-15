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
        Menu menu = new Menu();
        menu.run();
    }
}
