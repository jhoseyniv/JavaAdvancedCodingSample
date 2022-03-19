package com.designpattern.Behavioral.Observer.twitter;

public class NewYorkTimes implements NewsObserver {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("money")){
            System.out.println("Breaking News In Newyork times ! " + tweet);
        }
    }
}
