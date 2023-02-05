package com.quinbay.chatlogin.service;


import com.quinbay.chatlogin.apis.AuthenticateService;
import com.quinbay.chatlogin.model.Authenticate;
import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class AuthenticateServiceImpl implements AuthenticateService {

    @Autowired
    UserDetailsRepo userDetailsRepo;


    @Override
    public Object loginUser(Authenticate user){
        UserDetails repo = null;
        repo = userDetailsRepo.findByMobilenumAndPassword(user.getMobileNum(),user.getPassword());
        if(repo != null){
            repo.setLoginstatus("Active");
            userDetailsRepo.save(repo);
            Map<String, Object> addUser = new HashMap<>();
            addUser.put("loginstatus",true);
            addUser.put("userid", repo.getId());
            addUser.put("mobilenum",repo.getMobilenum());
            addUser.put("about",repo.getAbout());
            addUser.put("username",repo.getUsername());
            addUser.put("timestamp",repo.getCreatedon());
            addUser.put("updatedtimestamp",repo.getUpdatedon());
            return addUser;
        }
        return "Mobile Number or Password is incorrect";
    }



}
