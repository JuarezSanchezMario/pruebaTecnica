package com.pruebaTwitter.pruebaTecnica.model.service;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.api.service.TweetsManagementService;

import java.util.List;

public class TweetsManagementServiceImpl implements TweetsManagementService {
    @Override
    public List<TweetDTO> getAll() {
        return null;
    }

    @Override
    public List<TweetDTO> getValidatedTweets() {
        return null;
    }

    @Override
    public boolean validate(Integer id) {
        return false;
    }

    @Override
    public boolean saveTweets(List<TweetDTO> tweets) {
        return false;
    }
}
