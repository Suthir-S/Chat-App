package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.GroupsResponse;

import java.util.List;
import java.util.Map;

public interface GroupService {
    Groups addGroup(String groupname, String createdby , String userid);
    Map<Integer,GroupsResponse> getMembers(String mobilenum);
    List<GroupsResponse> showAllGroups();
    String deleteGroup(int groupid);
}
