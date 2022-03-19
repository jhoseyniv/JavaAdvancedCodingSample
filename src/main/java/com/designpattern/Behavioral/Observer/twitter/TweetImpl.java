package com.designpattern.Behavioral.Observer.twitter;

public class TweetImpl {
    public static void main(String args[]){
        FeedTweet ft = new FeedTweet();
        ft.register(new Guardian());
        ft.register(new NewYorkTimes());
        ft.register((String tweet) -> {
                    if(tweet.contains("war") && tweet != null ){
                        System.out.println("Russia Today Breaking News... Putin attack to another country Again...");
                    }
                }
        );
        ft.register((String tweet) -> {
            if(tweet != null && tweet.contains("Movie")){
                System.out.println("News From Los Angles times.....new movie introducd to market");
            }
        });
        ft.notify("The queen said her favourite book is Modern Java in Action!");
        ft.notify("Ukrain war may take along a few years!!!");
        ft.notify("See Movie Serial is published by mmmmm!!!");



    }
}
