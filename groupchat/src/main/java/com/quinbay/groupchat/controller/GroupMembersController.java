package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.service.GroupMembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GroupMembersController {

    @Autowired
    GroupMembersService groupMembersService;

    @PostMapping("/addMember")
    public String NewaddMembers(@RequestParam int groupid, @RequestParam String userid){
        return groupMembersService.addMember(groupid,userid);
    }

    @DeleteMapping("/removeMember")
    public String removeMember(@RequestParam int groupid, @RequestParam String userid){
        return groupMembersService.removeMember(groupid,userid);
    }


    @GetMapping("/displayAgroupMembers")
    public List<GroupMembers> getAllMembers(@RequestParam int groupid){
        return groupMembersService.findSpecific(groupid);
    }

    @GetMapping("/displayAllGroupMembersData")
    public List<GroupMembers> findAllData(){
        return groupMembersService.findAllData();
    }

}


//=================
//    @DeleteMapping
//    public String delete(@RequestParam int id){
//        return groupMembersService.deleteb(id);
//    }
//=================
