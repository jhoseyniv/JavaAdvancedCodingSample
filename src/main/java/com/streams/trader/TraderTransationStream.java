package com.streams.trader;

import java.util.Arrays;
import java.util.List;

public class TraderTransationStream {

    public static void main(String args[]){
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300, Currency.Doller),
                new Transaction(raoul, 2012, 1000,Currency.EUro),
                new Transaction(raoul, 2011, 400,Currency.RIAL),
                new Transaction(mario, 2012, 710,Currency.Doller),
                new Transaction(mario, 2012, 700,Currency.Doller),
                new Transaction(alan, 2012, 950,Currency.RIAL),
                new Transaction(brian, 2012, 350,Currency.EUro),
                new Transaction(raoul, 2012, 200,Currency.RIAL)
        );









    }
}
