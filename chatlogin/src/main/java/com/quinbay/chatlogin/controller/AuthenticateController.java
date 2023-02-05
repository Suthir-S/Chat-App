package com.quinbay.chatlogin.controller;

import com.quinbay.chatlogin.model.Authenticate;
import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import com.quinbay.chatlogin.service.AuthenticateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class AuthenticateController {

    @Autowired
    AuthenticateServiceImpl authenticateServiceImpl;

    @Autowired
    UserDetailsRepo userDetailsRepo;


    UserDetails loginUser = new UserDetails();
//    @PostMapping("/loginUser")
//    public Map<String, Object> displayuser(@RequestBody Authenticate user){
//        loginUser = userDetailsRepo.findByMobilenumAndPassword(user.getMobileNum(),user.getPassword());
//        return authenticateServiceImpl.loginUser(user);
//    }

    @PostMapping("/loginUser")
    public ResponseEntity<Object> loginUser(@RequestBody Authenticate user){
        loginUser = userDetailsRepo.findByMobilenumAndPassword(user.getMobileNum(),user.getPassword());
        Object response =  authenticateServiceImpl.loginUser(user);
        if(response.equals("Mobile Number or Password is incorrect")){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/logoutUser")
    public String logoutUser(){
        loginUser.setLoginstatus("Inactive");
        userDetailsRepo.save(loginUser);
        return "Logout Successful";
    }

    }
