package com.designpattern.Behavioral.command;

public class ActionSave implements ActionListenerCommand{

     private Document doc;
     public ActionSave(Document d){
         this.doc = d;
     }
    @Override
    public void execute() {
        doc.save();
    }
}
