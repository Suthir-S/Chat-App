package com.quinbay.contacts.service;


import com.quinbay.contacts.api.ContactsService;
import com.quinbay.contacts.model.Contacts;
import com.quinbay.contacts.model.ContactsResponse;
import com.quinbay.contacts.repository.ContactsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {

    @Autowired
    ContactsRepo contactsRepo;


    @Override
    public ContactsResponse addContact(String mobilenum) {
        Contacts fetchContact = null;
        fetchContact = contactsRepo.findByMobilenum(mobilenum);
        if (fetchContact != null) {
            return null;
        }
        Contacts addnew = new Contacts(mobilenum);
        contactsRepo.save(addnew);
        ContactsResponse res = new ContactsResponse(addnew.getId(),addnew.getMobilenum());
        return res;
    }

    public String editContact(int id, String mobilenum){
        Contacts findContact = null;
        findContact = contactsRepo.findById(id);
        if(findContact!=null){
            findContact.setMobilenum(mobilenum);
            contactsRepo.save(findContact);
            return "Contact Edited";
        }
        return "Contact Id not found";
    }

    @Override
    public List<ContactsResponse> findAllUsers() {
        List<Contacts> users = contactsRepo.findAll();
        List<ContactsResponse> contacts = new ArrayList<>();
        for(Contacts each:users){
            ContactsResponse response = new ContactsResponse(each.getId(),each.getMobilenum());
            contacts.add(response);
        }
        return contacts;
    }

}
