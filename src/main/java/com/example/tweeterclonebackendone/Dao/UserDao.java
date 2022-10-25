package com.example.tweeterclonebackendone.Dao;

import com.example.tweeterclonebackendone.Model.UserModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends CrudRepository<UserModel,Integer> {
    @Query(value = "SELECT `id`, `dob`, `email`, `name`, `pass`, `phn`, `place` FROM `user_tb` WHERE `email`=:email AND `pass`=:pass",nativeQuery = true)
    List<UserModel> signIn(String email, String pass);
}
