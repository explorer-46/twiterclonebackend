package com.example.tweeterclonebackendone.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tweet_tb")
public class TweetModel {
    @Id
    @GeneratedValue

    public int id;
    public String tweet;
    public String date;
    private int user_id;


    public TweetModel(int id, String tweet, String date, int user_id) {
        this.id = id;
        this.tweet = tweet;
        this.date = date;
        this.user_id = user_id;
    }

    public TweetModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
