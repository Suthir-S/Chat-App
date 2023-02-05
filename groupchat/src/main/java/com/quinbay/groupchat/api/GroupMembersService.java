package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.GroupMembersResponse;

import java.util.List;

public interface GroupMembersService {
    String addMember(int groupid, String userid);
    String removeMember(int groupid, String userid);
    List<GroupMembersResponse> findSpecific(int groupid);
    List<GroupMembers> findAllData();
}
