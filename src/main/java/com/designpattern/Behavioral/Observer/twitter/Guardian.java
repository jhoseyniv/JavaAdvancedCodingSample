package com.designpattern.Behavioral.Observer.twitter;

public class Guardian implements NewsObserver {
    @Override
    public void notify(String tweet) {
        if(tweet != null && tweet.contains("queen")){
            System.out.println("Yet more news from London... Guardian" + tweet);
        }
    }
}
