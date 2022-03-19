package com.designpattern.Behavioral.ChainOfResponsibility;

public class ProcessNumbers extends Processor{

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("[0-9]+" ,"-");
    }

    public ProcessNumbers() {
    }
}
