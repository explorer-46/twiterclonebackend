package com.example.tweeterclonebackendone.Dao;

import com.example.tweeterclonebackendone.Model.TweetModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TweetDao extends CrudRepository<TweetModel,Integer> {

    @Query(value = "SELECT t.`date`, t.`tweet`,u.name  FROM `tweet_tb`t JOIN user_tb u ON t.`user_id`=u.id",nativeQuery = true)
    List<String> viewAll();

    @Query(value = "SELECT `id`, `date`, `tweet`, `user_id` FROM `tweet_tb` WHERE `user_id`= :user_id",nativeQuery = true)
   public List<TweetModel> tweetByUserid(Integer user_id);
}
