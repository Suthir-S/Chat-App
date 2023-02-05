package com.quinbay.chatlogin.controller;


import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import com.quinbay.chatlogin.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@RestController
@CrossOrigin(origins = "*")
public class UserDetailsController {

    @Autowired
    UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    UserDetailsRepo userDetailsRepo;


    @PostMapping("/addUser")
    public UserDetails returnUser(@RequestParam String username, @RequestParam String mobileNum, @RequestParam String password, @RequestParam String about ){
        return userDetailsServiceImpl.add(username,mobileNum,password,about);
    }

    @PutMapping("/editUser")
    public UserDetails editUser(@RequestParam int userid, @RequestParam String username ,@RequestParam String about){
        return userDetailsServiceImpl.editUser(userid ,username ,about);
    }

    @GetMapping("/displayUsers")
    public ArrayList<UserDetails> getAllUsers() {
        return userDetailsServiceImpl.findAllUsers();
    }
}
