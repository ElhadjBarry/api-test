package com.test.app.api.Controller;

import com.test.app.api.Models.User;
import com.test.app.api.Repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiControllers {
    @Autowired
    private UserRepo userRepo;
    @GetMapping("/")
    public String getPage(){
        return "Bienvenue!";
    }
    @GetMapping(value="/users")
    public List<User> getUsers(){
        return userRepo.findAll();
    }
    @PostMapping(value = "/save")
    public ResponseEntity<User>  saveUser(@RequestBody User user){
        userRepo.save(user);
        if (userRepo != null){
            return  new ResponseEntity<User>(user, HttpStatus.OK);
        }else{
            return  new ResponseEntity<User>(user, HttpStatus.BAD_REQUEST);
        }
    }
}
