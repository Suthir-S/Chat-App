package com.quinbay.groupchat.service;

import com.quinbay.groupchat.api.GroupInterface;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GroupService implements GroupInterface {

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
    public Map<Integer,Groups> getMembers(String mobilenum) {
        List<GroupMembers> members = groupMembersRepo.findByUserid(mobilenum);
        Map<Integer,Groups> groups = new HashMap<>();
        for (GroupMembers g : members) {
            groups.put(g.getGroup().getId(),g.getGroup());
        }
        return groups;
    }

    @Override
    public List<Groups> showAllGroups(){
        return groupRepo.findAll();
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