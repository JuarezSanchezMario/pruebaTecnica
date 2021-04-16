package com.pruebaTwitter.pruebaTecnica.model.utils;

import com.pruebaTwitter.pruebaTecnica.api.dto.TweetDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwitterUtils {
    public static List<String> getHashtags(TweetDTO tweetDTO){
        List<String> hashTags = new ArrayList<>();

        Pattern MY_PATTERN = Pattern.compile("#(\\S+)");
        Matcher matcher = MY_PATTERN.matcher(tweetDTO.getText());

        while (matcher.find()) {
            hashTags.add(matcher.group(1));
        }
        return hashTags;
    }
}
