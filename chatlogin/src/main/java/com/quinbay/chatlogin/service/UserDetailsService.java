package com.quinbay.chatlogin.service;

import com.quinbay.chatlogin.apis.UserDetailsInterface;
import com.quinbay.chatlogin.model.UserDetails;
import com.quinbay.chatlogin.repository.UserDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class UserDetailsService implements UserDetailsInterface {

    @Autowired
    UserDetailsRepo userDetailsRepo;


    @Override
    public UserDetails add(String username,String mobilenum,String password,String about){
        UserDetails person = new UserDetails(username,mobilenum,password,about);
        return userDetailsRepo.save(person);
    }


    @Override
    public UserDetails editUser(int userid ,  String username ,String about ) {
        UserDetails edituser = null;
        edituser = userDetailsRepo.findById(userid);
        edituser.setAbout(about);
        edituser.setUsername(username);
        userDetailsRepo.save(edituser);
        return edituser;
    }

    @Override
    public ArrayList<UserDetails> findAllUsers() {
        return (ArrayList<UserDetails>) userDetailsRepo.findAll();
    }

}
