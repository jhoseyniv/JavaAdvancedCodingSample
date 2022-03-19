package com.designpattern.Behavioral.Observer.twitter;

import java.util.ArrayList;
import java.util.List;

public class FeedTweet implements NewsSubject{
    private final List<NewsObserver> obeservers = new ArrayList<>();

    @Override
    public void register(NewsObserver newsObserver) {
        obeservers.add(newsObserver);
    }

    @Override
    public void notify(String tweet) {
        obeservers.forEach(ob -> ob.notify(tweet));
    }

}
