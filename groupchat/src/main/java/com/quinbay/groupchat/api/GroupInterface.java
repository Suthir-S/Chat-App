package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Groups;

import java.util.List;
import java.util.Map;

public interface GroupInterface {
    Groups addGroup(String groupname, String createdby , String userid);
    Map<Integer,Groups> getMembers(String mobilenum);
    List<Groups> showAllGroups();
    String deleteGroup(int groupid);
}
