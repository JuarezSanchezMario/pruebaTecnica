package com.pruebaTwitter.pruebaTecnica.model.repository.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "TWITTER_BDD")
public class Tweet {

    @Id
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "text",columnDefinition="LONGTEXT")
    private String text;

    @Column(name = "locale")
    private String locale;

    @Column(name = "validated")
    private Boolean validated;

    public Tweet() {
    }

    public Tweet(Integer userId, String userName, String text, String locale, Boolean valid) {
        this.userId = userId;
        this.userName = userName;
        this.text = text;
        this.locale = locale;
        this.validated = valid;
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

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

}
