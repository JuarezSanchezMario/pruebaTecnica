package com.pruebaTwitter.pruebaTecnica.api.service;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.api.dto.TwitterHashtagRelated;

import java.util.List;

public interface TweetsManagementService {
    List<TweetDTO> getAll();
    List<TweetDTO> getValidatedTweets(String user);
    boolean validate(Integer id);
    void saveTweets(List<TweetDTO>tweets);
    List<TwitterHashtagRelated> getMostUsedHashtags(Integer nHashtags);
}
