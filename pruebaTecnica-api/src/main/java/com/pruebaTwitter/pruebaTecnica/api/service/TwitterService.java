package com.pruebaTwitter.pruebaTecnica.api.service;
import twitter4j.*;

import java.util.List;

public interface TwitterService {
    List<Status> getFilteredTweets(String user);
    List<Status> filterTweets(List<Status> status);
}
