package commands;

public interface Command {

    String execute();

    String execute(String args[]);
}
