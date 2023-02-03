package com.quinbay.chatlogin.service;


import com.quinbay.chatlogin.apis.AuthenticateInterface;
import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticateService implements AuthenticateInterface {

    @Autowired
    UserDetailsRepo userDetailsRepo;

    Map<String, Object> addUser = new HashMap<>();

    @Override
    public Map<String, Object> loginUser(String mobilenum , String password ){
        UserDetails repo = null;
        repo = userDetailsRepo.findByMobilenumAndPassword(mobilenum,password);
        if(repo != null){
            UserDetails user = userDetailsRepo.findByMobilenumAndPassword(mobilenum,password);
            user.setLoginstatus("Active");
            userDetailsRepo.save(user);
            addUser.put("loginstatus",true);
            addUser.put("userid", user.getId());
            addUser.put("mobilenum",user.getMobilenum());
            addUser.put("about",user.getAbout());
            addUser.put("username",user.getUsername());
            addUser.put("timestamp",user.getCreatedon());
            addUser.put("updatedtimestamp",user.getUpdatedon());
            return addUser;
        }
        Map<String, Object> empUser = new HashMap<>();
        UserDetails user = userDetailsRepo.findByMobilenumAndPassword(mobilenum,password);
        empUser.put("loginstatus",false);
        return empUser;
    }



}
