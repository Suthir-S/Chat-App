package com.quinbay.groupchat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupMembers {
    @Id
    @SequenceGenerator(name = "members" , sequenceName = "members", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "members")
    @Column(name = "memberid")
    Integer id;
    String userid;  //mobilenum

    @ManyToOne
    @JoinColumn(name = "group_id",referencedColumnName = "groupid")
    @JsonIgnore
    Groups group;

    @Column(name = "group_member_id")
    int groupid;
}
