package com.quinbay.chatlogin.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {
    @Id
    @SequenceGenerator(name = "users" , sequenceName = "users", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "users")
    int id;
    public UserDetails(String username, String mobilenum, String password, String about) {
        this.username = username;
        this.mobilenum = mobilenum;
        this.password = password;
        this.about = about;
    }

    String username;
    String mobilenum;
    @JsonIgnore
    String password;
    String about;
    @CreationTimestamp
    LocalDateTime createdon;
    @UpdateTimestamp
    LocalDateTime updatedon;
    String loginstatus = "Inactive";
}
