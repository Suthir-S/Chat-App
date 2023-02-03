package com.quinbay.groupchat.service;


import com.quinbay.groupchat.api.GroupMembersInterface;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupMembersService implements GroupMembersInterface {

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Autowired
    GroupRepo groupRepo;

//    @Autowired
//    MessageRepo messageRepo;

    @Override
    public String addMember(int groupid, String userid) {
        try {
            Groups group = groupRepo.findById(groupid);
            if (group != null) {
                GroupMembers fetchMembers = groupMembersRepo.findByUseridAndGroupId(userid,groupid);
                if(fetchMembers==null){
                    GroupMembers groupMember = new GroupMembers();
                    groupMember.setUserid(userid);
                    groupMember.setGroup(group);
                    groupMember.setGroupid(group.getId());
                    groupMembersRepo.save(groupMember);
                    System.out.println(groupMember.getGroup().getGroupname());
                    return "Member "+ groupMember.getUserid() +"  added";
                }
                return "User "+ fetchMembers.getUserid() +" already in the group";
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }
        return "Group doesn't exists";
    }

    @Override
    public String removeMember(int groupid, String userid) {
        GroupMembers groupMember = groupMembersRepo.findByUseridAndGroupId(userid, groupid);
        if(groupMember!=null){
                groupMembersRepo.delete(groupMember);
                return "Member Removed";
        }
        return "Member Doesn't Exist";
    }

    //---------Multiple contacts add-------------
    /*
    public String addMembers(List<Contacts> users, int groupid) {
        try {
            List<GroupMembers> fetchGroupMem = groupMembersRepo.findByGroupid(groupid); //HashMap<key as phone num,Value as groupid>
            Groups fetchGroup = groupRepo.findById(groupid);
            for (Contacts con : users) {
                for (GroupMembers memcheck : fetchGroupMem) {
                    if (con.getMobilenum() != memcheck.getUserid())   {                 //key
                        GroupMembers groupMembers = new GroupMembers();
                        groupMembers.setUserid(con.getMobilenum());
                        groupMembers.setGroupid(groupid);
                        groupMembers.setGroup(fetchGroup);
                        groupMembersRepo.save(groupMembers);
                        //System.out.println(groupMembers.getGroup().getGroupname());
                        System.out.println("Member " + groupMembers.getUserid() + "  added");
                    } else {
                        return "User " + memcheck.getUserid() + " already in the group";
                    }
                }
            }
            return "Members added";
        } catch (Exception e) {
            System.out.println(e);
        }
        return "Group doesn't exists";
    }
    */
    //---------Multiple contacts add-------------//

    @Override
    public List<GroupMembers> findSpecific(int groupid) {
        List<GroupMembers> message = groupMembersRepo.findByGroupid(groupid);
        return message;
    }

    @Override
    public List<GroupMembers> findAllData(){
        return groupMembersRepo.findAll();
    }

}


//------------------------------------------
//    public String deleteb(int memberid){
//        groupMembersRepo.deleteById(memberid);
//        return "deleted";
//    }
