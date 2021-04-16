package com.pruebaTwitter.pruebaTecnica.model.service;

import com.pruebaTwitter.pruebaTecnica.api.service.TwitterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TwitterServiceImpl implements TwitterService {

    Logger log = LoggerFactory.getLogger(TwitterServiceImpl.class);

    @Value( "${twitter.filters.locales}" )
    String[] allowedLocale;
    @Value( "${twitter.filters.minFollowers}" )
    Integer minFollowers;

    @Override
    public List<Status> getFilteredTweets(String user) {
        Twitter twitter = new TwitterFactory().getInstance();
        List<String>  allowedList = Arrays.asList(allowedLocale);
        List<Status> status = new ArrayList<>();
        try {
            status = twitter.getUserTimeline(user);
            log.info("@"+user+ "tweets");
        } catch (TwitterException ex) {
            log.error("Failed retrieving tweets from " +user);
            log.error(ex.getMessage());
        }
        log.info("Doing logic for filter the tweets");
        return status.stream()
                .filter(item -> (item.getUser().getFollowersCount() >= minFollowers) && (allowedList.contains(item.getLang())))
                .collect(Collectors.toList());
    }
}
