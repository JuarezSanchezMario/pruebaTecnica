package com.pruebaTwitter.pruebaTecnica.api.dto;

import java.io.Serializable;

public class TwitterHashtagRelated implements Serializable {
    public String userName;

    public String hashtag;

    public Integer nHashtags;

    public TwitterHashtagRelated() {
    }

    public TwitterHashtagRelated(String userName, String hashtag, Integer nHashtags) {
        this.userName = userName;
        this.hashtag = hashtag;
        this.nHashtags = nHashtags;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Integer getnHashtags() {
        return nHashtags;
    }

    public void setnHashtags(Integer nHashtags) {
        this.nHashtags = nHashtags;
    }
}
