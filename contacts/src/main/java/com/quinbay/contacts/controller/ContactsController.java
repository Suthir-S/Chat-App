package com.quinbay.contacts.controller;


import com.quinbay.contacts.model.ContactsResponse;
import com.quinbay.contacts.service.ContactsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ContactsController {

    @Autowired
    ContactsServiceImpl contactsServiceImpl;


    @PostMapping("/addUser")
    public ContactsResponse returnUser(@RequestParam String mobilenum) {
        return contactsServiceImpl.addContact(mobilenum);
        //return userDetailsService.findUsername(username,mobilenum,password);
    }

//    @PostMapping("/addNewUser")
//    public Map<Object,String>  returnUsers(@RequestParam String mobilenum, @RequestParam String usercontactname) {
//        return contactsServiceImpl.addUserConatct(mobilenum,usercontactname);
//        //return userDetailsService.findUsername(username,mobilenum,password);
//    }

    @PutMapping("/editContact")
    public String editContact(@RequestParam int id , @RequestParam String mobilenum){
        return contactsServiceImpl.editContact(id,mobilenum);
    }

    @GetMapping("/displayContacts")
    public List<ContactsResponse> getAllUsers() {
        return contactsServiceImpl.findAllUsers();
    }
}
