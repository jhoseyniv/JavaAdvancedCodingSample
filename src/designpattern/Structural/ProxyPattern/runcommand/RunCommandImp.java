package designpattern.Structural.ProxyPattern.runcommand;

import java.io.IOException;

public class RunCommandImp implements RunCommand{

    private String command;

    public RunCommandImp(String command) {
        this.command = command;
    }

    @Override
    public void RunACommand(String cmd) throws IOException {
        Runtime.getRuntime().exec(cmd);
        System.out.println("'" + cmd + "' command executed.");
    }
}
