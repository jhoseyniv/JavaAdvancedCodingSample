package com.designpattern.Behavioral.ChainOfResponsibility;

public abstract class Processor {
    private Processor nextProcessor;

    public void setNextProcessor(Processor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }
    public String handleChain(String input){
        String output = handleWork(input);
        if(nextProcessor != null)
            return nextProcessor.handleWork(input);
        return output;
    }
    abstract protected String handleWork(String input);

}
