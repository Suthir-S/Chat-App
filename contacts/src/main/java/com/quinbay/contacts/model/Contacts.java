package com.quinbay.contacts.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Contacts {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @Column(name = "mobilenum")
    String mobilenum;

    public Contacts(String mobilenum) {
        this.mobilenum = mobilenum;
    }
}
