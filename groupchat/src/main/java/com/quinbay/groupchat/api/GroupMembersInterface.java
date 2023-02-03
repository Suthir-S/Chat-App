package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.GroupMembers;

import java.util.List;

public interface GroupMembersInterface {
    String addMember(int groupid, String userid);
    String removeMember(int groupid, String userid);
    List<GroupMembers> findSpecific(int groupid);
    List<GroupMembers> findAllData();
}
