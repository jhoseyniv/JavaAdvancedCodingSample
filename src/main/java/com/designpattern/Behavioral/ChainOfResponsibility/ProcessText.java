package com.designpattern.Behavioral.ChainOfResponsibility;

public class ProcessText extends  Processor{
    @Override
    protected String handleWork(String input) {
        return input.replaceAll("Java" ," jjj modern");
    }

    public ProcessText() {
    }
}
