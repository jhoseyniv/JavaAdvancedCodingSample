package com.designpattern.Behavioral.ChainOfResponsibility;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ChainOfResponsImpl {
    private static Processor getChainOfProcessor(){
        Processor pn = new ProcessNumbers();
        Processor pt = new ProcessText();
        pn.setNextProcessor(pt);
        return pn;
    }

    public static void main(String args[]) {
        Processor processChain = getChainOfProcessor();
        String result = processChain.handleChain("1395 Jalal 1400 Hosseini Java 8 Modern...");
        System.out.println(result);


        UnaryOperator<String> headerProcessing =
                (String text) -> "From Raoul, Mario and Alan: " + text;
        UnaryOperator<String> spellCheckerProcessing =
                (String text) -> text.replaceAll("labda", "lambda");
        Function<String, String> pipeline =
                headerProcessing.andThen(spellCheckerProcessing);
        String result2 = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(result2);

    }
}
