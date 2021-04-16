package com.pruebaTwitter.pruebaTecnica.model.service;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import com.pruebaTwitter.pruebaTecnica.api.dto.TwitterHashtagRelated;
import com.pruebaTwitter.pruebaTecnica.api.service.TweetsManagementService;
import com.pruebaTwitter.pruebaTecnica.model.mapper.TweetMapper;
import com.pruebaTwitter.pruebaTecnica.model.repository.TweetRepository;
import com.pruebaTwitter.pruebaTecnica.model.utils.TwitterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class TweetsManagementServiceImpl implements TweetsManagementService {

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    TweetMapper tweetMapper;

    Logger log = LoggerFactory.getLogger(TweetsManagementServiceImpl.class);

    @Override
    public List<TweetDTO> getAll() {
        log.info("Retrieving all tweets");
        return tweetMapper.asTweetDTOList(tweetRepository.findAll());
    }

    @Override
    public List<TweetDTO> getValidatedTweets(String user) {
        log.info("Retrieving all valited tweets");
        return tweetMapper.asTweetDTOList(tweetRepository.findByValidatedTrueAndUserNameLike(user));
    }

    @Override
    public boolean validate(Integer id) {
        log.info("Validating tweet with id:"+id);
        AtomicBoolean validated = new AtomicBoolean(false);
        tweetRepository.findById(id).ifPresent(tweet -> {tweet.setValidated(Boolean.TRUE);  validated.set(true); tweetRepository.save(tweet); log.info(tweet.getValidated()+"");});

        log.info("Tweet valid: "+validated.get());
        return validated.get();
    }

    @Override
    public void saveTweets(List<TweetDTO> tweets) {
        log.info("Saving tweets in bdd");
        tweetRepository.saveAll(tweetMapper.asTweetList(tweets));
    }

    @Override
    public List<TwitterHashtagRelated> getMostUsedHashtags(Integer nHashtags) {
        log.info("Retrieving and filtering");
        List<TweetDTO> listTweets = tweetMapper.asTweetDTOList(tweetRepository.findAll());
        List<TwitterHashtagRelated> twitterHashtagRelated = new ArrayList<>();
        List<String> hashtags = new ArrayList<>();
        List<String> hashtagsWithNoDuplicates;

        log.info("Applying logic");
        listTweets.forEach(tweetDTO -> hashtags.addAll(TwitterUtils.getHashtags(tweetDTO)));
        hashtagsWithNoDuplicates = hashtags.stream().distinct().collect(Collectors.toList());
        hashtagsWithNoDuplicates.forEach(hashtag -> twitterHashtagRelated.add(new TwitterHashtagRelated(hashtag,Collections.frequency(hashtags,hashtag))));
        log.info("Sorting and returning");
        twitterHashtagRelated.sort(Comparator.comparing(TwitterHashtagRelated::getnHashtags).reversed());

        return twitterHashtagRelated.stream().limit(nHashtags).collect(Collectors.toList());
    }
}
