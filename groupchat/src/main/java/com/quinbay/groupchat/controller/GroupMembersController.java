package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.GroupMembersResponse;
import com.quinbay.groupchat.service.GroupMembersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@CrossOrigin(origins = "*")
public class GroupMembersController {

    @Autowired
    GroupMembersServiceImpl groupMembersServiceImpl;

    @PostMapping("/addMember")
    public String NewaddMembers(@RequestParam int groupid, @RequestParam String userid){
        return groupMembersServiceImpl.addMember(groupid,userid);
    }

    @DeleteMapping("/removeMember")
    public String removeMember(@RequestParam int groupid, @RequestParam String userid){
        return groupMembersServiceImpl.removeMember(groupid,userid);
    }


    @GetMapping("/displayAgroupMembers")
    public List<GroupMembersResponse> getAllMembers(@RequestParam int groupid){
        return groupMembersServiceImpl.findSpecific(groupid);
    }

    @GetMapping("/displayAllGroupMembersData")
    public List<GroupMembers> findAllData(){
        return groupMembersServiceImpl.findAllData();
    }

}


//=================
//    @DeleteMapping
//    public String delete(@RequestParam int id){
//        return groupMembersServiceImpl.deleteb(id);
//    }
//=================
