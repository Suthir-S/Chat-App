package com.quinbay.chatlogin.apis;

import com.quinbay.chatlogin.model.UserDetails;

import java.util.ArrayList;

public interface UserDetailsInterface {
    UserDetails add(String username,String mobilenum,String password,String about);
    UserDetails editUser(int userid ,  String username ,String about );
    ArrayList<UserDetails> findAllUsers();
}
