package com.pruebaTwitter.pruebaTecnica.api.dto;

import java.io.Serializable;

public class TweetDTO implements Serializable {

    private Integer userId;
    private String userName;
    private String text;
    private String locale;
    private boolean valid;

    public TweetDTO() {
    }

    public TweetDTO(Integer userId, String userName, String text, String locale, boolean valid) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.locale = locale;
        this.valid = valid;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }
}
