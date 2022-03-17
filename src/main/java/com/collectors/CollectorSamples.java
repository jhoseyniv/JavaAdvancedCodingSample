package com.collectors;

import com.streams.trader.Currency;
import com.streams.trader.Trader;
import com.streams.trader.Transaction;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.util.stream.Collectors;

public class CollectorSamples {
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
        Map<Currency,List<Transaction>> transactionGroupByCurrency = new HashMap<>();

        transactionGroupByCurrency = transactions.stream().collect(Collectors.groupingBy(Transaction::getCurrency,Collectors.toList()));
        transactionGroupByCurrency.entrySet().forEach(System.out::println);

        long howManyTransations = transactions.stream().collect(counting());
        System.out.println("Number Of transactions is :  " + howManyTransations);

        //Finding maximum and minimum in a stream of values
        Comparator<Transaction> transactionComparator = Comparator.comparingInt(Transaction::getValue);
        Optional<Transaction> mostCalorieDish = transactions.stream().collect(maxBy(transactionComparator));

        int totalvalues = transactions.stream().collect(summingInt(Transaction::getValue));

        double avrageValue = transactions.stream().collect(averagingInt(Transaction::getValue));

        //you can use the collector returned by the summarizingInt factory method.
        //For example, you can count the elements in the menu and obtain the sum, average, maximum, and minimum of the calories contained in each dish with a single
        //summarizing operation:

        IntSummaryStatistics intSummaryStatistics = transactions.stream().collect(summarizingInt(Transaction::getValue));
        System.out.println("Summerize information about value of Transactions....");
        System.out.println(intSummaryStatistics);


        for (Transaction transaction : transactions) {
            if(transaction.getTrader().getName().equalsIgnoreCase("Alan")) {
               // transactions.remove(transaction); //exception in thread "main" java.lang.UnsupportedOperationException
            }
        }

        for (Iterator<Transaction> iterator = transactions.iterator();
             iterator.hasNext(); ) {
            Transaction transaction = iterator.next();
            if(transaction.getTrader().getName().equalsIgnoreCase("Alan")) {
                //iterator.remove(); //  //exception in thread "main" java.lang.UnsupportedOperationException becuase transations list is immutable
            }
        }
        transactions.removeIf(transaction ->
                transaction.getTrader().getName().equalsIgnoreCase("Alan"));
    }

}
