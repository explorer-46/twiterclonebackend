package com.example.tweeterclonebackendone.Controller;

import com.example.tweeterclonebackendone.Dao.TweetDao;
import com.example.tweeterclonebackendone.Model.TweetModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class TweetController {
    @Autowired
    private TweetDao dao;

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/addweet",consumes = "application/json",produces = "application/json")
    public String addTweet(@RequestBody TweetModel tweet){
        DateTimeFormatter dt=DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String currentdate=String.valueOf(dt.format(now));
        tweet.setDate(currentdate);
        dao.save(tweet);
        return "{status:'success'}";
    }
    @CrossOrigin(value = "*")
    @GetMapping("viewtweet")
    public List<String> viewTweets(){
        return (List<String>) dao.viewAll();

    }
    @CrossOrigin(value = "*")
    @PostMapping(path = "/single",consumes = "application/json",produces = "application/json")
     public List<TweetModel>viewSingle(@RequestBody TweetModel tm){
        return (List<TweetModel>) dao.tweetByUserid(tm.getUser_id());
    }
}
