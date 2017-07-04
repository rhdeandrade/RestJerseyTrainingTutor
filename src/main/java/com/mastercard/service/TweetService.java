package com.mastercard.service;

import com.mastercard.model.Tweet;

import java.util.HashMap;
import java.util.List;

/**
 * Created by e068806 on 7/3/2017.
 */
public class TweetService {
    private HashMap<Long, Tweet> tweets = new HashMap<>();
    private static TweetService tweetService;
    private Long id = 0l;

    public static TweetService getInstance() {
        if (tweetService == null)
            tweetService = new TweetService();
        return tweetService;
    }

    public Tweet createTweet(Tweet t) {
        if (t.getUserId() == null)
            return null;
        t.setId(id.longValue());
        tweets.put(t.getId(), t);
        id++;
        return t;
    }

    public Tweet updateTweet(Tweet t) {
        if (t.getId() == null || t.getUserId() == null)
            return null;

        tweets.put(t.getId(), t);
        return t;
    }

    public void removeTweet(Tweet t) {
        if (t.getId() == null)
            return;

        tweets.remove(t.getId());
    }

    public Tweet getTweet(Long id) {
        return tweets.get(id);
    }
}
