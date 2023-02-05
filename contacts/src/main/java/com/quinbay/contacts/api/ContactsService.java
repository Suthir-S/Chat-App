package com.quinbay.contacts.api;

import com.quinbay.contacts.model.Contacts;
import com.quinbay.contacts.model.ContactsResponse;

import java.util.ArrayList;
import java.util.List;

public interface ContactsService {
    ContactsResponse addContact(String mobilenum);
    List<ContactsResponse> findAllUsers();
}
