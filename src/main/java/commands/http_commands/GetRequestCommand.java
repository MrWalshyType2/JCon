package commands.http_commands;

import command_services.HttpService;
import commands.Command;

public class GetRequestCommand implements Command {

    HttpService httpService;

    public GetRequestCommand(HttpService httpService) {
        this.httpService = httpService;
    }

    @Override
    public String execute() {
        return httpService.getRequest();
    }

    @Override
    public String execute(String[] args) {
        return null;
    }
}
