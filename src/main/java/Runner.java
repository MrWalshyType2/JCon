import command_services.FileService;
import commands.CreateFileCommand;

public class Runner {

    public static void main(String args[]) {

        SingleCommandInvoker singleInvoker = new SingleCommandInvoker();
        String res = singleInvoker.executeCommand(new CreateFileCommand(new FileService()));
        System.out.println(res);
    }
}
