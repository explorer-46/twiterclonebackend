package com.example.tweeterclonebackendone.Controller;

import com.example.tweeterclonebackendone.Dao.UserDao;
import com.example.tweeterclonebackendone.Model.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController

public class UserController {
    @Autowired
    private UserDao dao;

    @CrossOrigin(value = "*")
    @PostMapping(path = "/adduser",consumes = "application/json",produces = "application/json")
    public String addUser(@RequestBody UserModel us){
        dao.save(us);
        return "{status:'success'}";
    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/signin",consumes = "application/json",produces = "application/json")
    public List<UserModel> signIn(@RequestBody UserModel um){
        return (List<UserModel>) dao.signIn(um.getEmail(),um.getPass());
    }
}


