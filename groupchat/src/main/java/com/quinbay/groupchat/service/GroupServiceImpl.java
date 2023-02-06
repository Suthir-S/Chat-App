package com.quinbay.groupchat.service;

import com.quinbay.groupchat.api.GroupService;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.GroupsResponse;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Override
    public Groups addGroup(String groupname, String createdby , String userid){
        Groups newgroup = new Groups(groupname,createdby);
        groupRepo.save(newgroup);
        addMember(newgroup);
        if(userid!="" && userid!="undefined"){
            GroupMembers groupMember = new GroupMembers();
            groupMember.setUserid(userid);
            groupMember.setGroup(newgroup);
            groupMember.setGroupid(newgroup.getId());
            groupMembersRepo.save(groupMember);
        }

        return newgroup;
    }

    public GroupMembers addMember(Groups newgroup){
        GroupMembers groupMember = new GroupMembers();
        groupMember.setUserid(newgroup.getCreatedby());
        groupMember.setGroup(newgroup);
        groupMember.setGroupid(newgroup.getId());
        groupMembersRepo.save(groupMember);
        return groupMember;
    }


    @Override
    public Map<Integer,GroupsResponse> getMembers(String mobilenum) {
        List<GroupMembers> members = groupMembersRepo.findByUserid(mobilenum);
        Map<Integer,GroupsResponse> groups = new HashMap<>();
        for (GroupMembers g : members) {
            groups.put(g.getGroup().getId(),new GroupsResponse(g.getGroup().getId(),g.getGroup().getGroupname(),g.getGroup().getCreatedby(),g.getGroup().getCreatedon()));
        }
        return groups;
    }


    //======

    @Override
    public List<GroupsResponse> showAllGroups(){
        List<Groups> group = groupRepo.findAll();
        List<GroupsResponse> addResponse= new ArrayList<>();
        for(Groups g : group){
            GroupsResponse newRes = new GroupsResponse(g.getId(),g.getGroupname(),g.getCreatedby(),g.getCreatedon());
            addResponse.add(newRes);
        }
        return addResponse;
    }

    @Override
    public String deleteGroup(int groupid) {
        Groups fetchGroup = groupRepo.findById(groupid);
            if(fetchGroup!=null) {
                List<GroupMembers> members = groupMembersRepo.findByGroupid(groupid);
                if (members.isEmpty()) {
                    groupRepo.deleteById(groupid);
                    return "Group Deleted";
                }
                return "Remove Group member";
            }
            return "Group doesn't exist!";
    }


}