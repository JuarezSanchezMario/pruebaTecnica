package com.pruebaTwitter.pruebaTecnica.model.starterLoader;

import com.pruebaTwitter.pruebaTecnica.api.service.TweetsManagementService;
import com.pruebaTwitter.pruebaTecnica.api.service.TwitterService;
import com.pruebaTwitter.pruebaTecnica.model.service.TwitterServiceImpl;
import org.slf4j.Logger;
import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import twitter4j.Status;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class TwitterLoader {

    Logger log = LoggerFactory.getLogger(TwitterServiceImpl.class);

    @Autowired
    TwitterService twitterService;

    @Autowired
    TweetsManagementService tweetsManagementService;


    @Value( "${twitter.starter.load}" )
    String[] usersToLoad;



    @PostConstruct
    public void loadInitialTweets(){
        log.info("Loading initial tweets");
        List<TweetDTO> tweetList = new ArrayList<>();

        Arrays.asList(usersToLoad).forEach(
                user -> tweetList.addAll(statusToDTO(getTweets(user)))
        );

        log.info("loadInitialTweets - number of tweets retrieved: " + tweetList.size());

        if(!tweetList.isEmpty()){
            log.info("Saving tweets");
            tweetsManagementService.saveTweets(tweetList);
        }
    }

    /**
     * Use this method for data manipulation
     * @param statusList statusList
     * @return list of converted tweets
     */
    public List<TweetDTO> statusToDTO(List<Status> statusList){
        return statusList.stream()
                .map(status -> new TweetDTO((int)(status.getId()),status.getUser().getName(),status.getText(),status.getLang(), Boolean.FALSE))
                .collect(Collectors.toList());
    }


    /**
     * @param twitterUser twitterUser
     * @return list of tweets
     */
    public List<Status> getTweets(String twitterUser){
        return twitterService.getFilteredTweets(twitterUser);
    }

}
