package com.pruebaTwitter.pruebaTecnica.model.service;

import com.pruebaTwitter.pruebaTecnica.api.service.TwitterService;
import twitter4j.Status;

import java.util.List;

public class TwitterServiceImpl implements TwitterService {

    @Override
    public List<Status> getFilteredTweets(String user) {
        return null;
    }

    @Override
    public List<Status> filterTweets(List<Status> status) {
        return null;
    }
}
