package com.quinbay.groupchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupMembersResponse {
    Integer id;
    String userid;
    public Groups group;

    public GroupMembersResponse(int id,String userid,Groups group){
        this.id = id;
        this.userid = userid;
        this.group = group;
    }
}
