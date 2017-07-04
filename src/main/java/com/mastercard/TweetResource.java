package com.mastercard;

import com.mastercard.service.TweetService;

import javax.ws.rs.Path;

/**
 * Created by e068806 on 7/3/2017.
 */
@Path("tweets")
public class TweetResource {
    TweetService tweetService = TweetService.getInstance();
    
}
