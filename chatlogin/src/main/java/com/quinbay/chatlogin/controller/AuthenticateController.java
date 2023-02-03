package com.quinbay.chatlogin.controller;

import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import com.quinbay.chatlogin.service.AuthenticateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class AuthenticateController {

    @Autowired
    AuthenticateService authenticateService;

    @Autowired
    UserDetailsRepo userDetailsRepo;


    UserDetails loginUser = new UserDetails();
    @PostMapping("/loginUser")
    public Map<String, Object> displayuser(@RequestParam String mobilenum ,@RequestParam String password ){
        loginUser = userDetailsRepo.findByMobilenumAndPassword(mobilenum,password);
        return authenticateService.loginUser(mobilenum,password);
    }


    @PostMapping("/logoutUser")
    public String logoutUser(){
        loginUser.setLoginstatus("Inactive");
        userDetailsRepo.save(loginUser);
        return "Logout Successful";
    }

    }

