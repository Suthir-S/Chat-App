package com.quinbay.groupchat.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Groups implements Serializable {
    @Id
    @SequenceGenerator(name = "groupsid" , sequenceName = "groupsid", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "groupsid")
    @Column(name = "groupid")
    Integer id;
    String groupname;
    String createdby;
    @CreationTimestamp
    Date createdon;

//    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL)
//    List<GroupMembers> members = new ArrayList<>();

    public Groups(String groupname, String createdby) {
        this.groupname = groupname;
        this.createdby = createdby;
    }

}
