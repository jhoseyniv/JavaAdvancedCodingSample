package designpattern.Structural.ProxyPattern.runcommand;

import java.io.IOException;

public class RunCommandProxy implements RunCommand{
    private boolean isAccess;

    private  RunCommandImp runCommandImp;

    public RunCommandProxy(String user, String pass) {
        if(user.equalsIgnoreCase("admin") && pass.equalsIgnoreCase("admin")) isAccess=false;
    }

    @Override
    public void RunACommand(String command) throws IOException {
        if(isAccess){
            Runtime.getRuntime().exec(command);
        }else {
            if(command.trim().equalsIgnoreCase("del"))  throw new IOException("user can not execute this command");
            else   runCommandImp.RunACommand(command);

        }
        }
    }

