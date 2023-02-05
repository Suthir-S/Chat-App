package com.quinbay.contacts.repository;

import com.quinbay.contacts.model.Contacts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ContactsRepo extends JpaRepository<Contacts,Integer> {
    Contacts findByMobilenum(String mobilenum);
    Contacts findById(int id);
}
