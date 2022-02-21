package com.designpattern.Structural.ProxyPattern.runcommand;

import java.io.IOException;

public class RunCommandProxyTest {
    public static void  main(String[] args){
        RunCommand runCommand=new RunCommandProxy("admin","admin");
        try {
          //  runCommand.RunACommand("delete");
            runCommand.RunACommand("insert");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
