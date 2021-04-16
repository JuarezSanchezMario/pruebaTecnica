package com.pruebaTwitter.pruebaTecnica.api.dto;

import java.io.Serializable;

public class TwitterHashtagRelated implements Serializable {

    public String hashtag;

    public Integer nHashtags;

    public TwitterHashtagRelated() {
    }

    public TwitterHashtagRelated(String hashtag, Integer nHashtags) {
        this.hashtag = hashtag;
        this.nHashtags = nHashtags;
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
