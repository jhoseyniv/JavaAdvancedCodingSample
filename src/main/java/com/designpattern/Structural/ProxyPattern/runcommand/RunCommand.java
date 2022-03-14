package com.designpattern.Structural.ProxyPattern.runcommand;

import java.io.IOException;

public interface RunCommand {
    public void RunACommand(String command) throws IOException;
}
