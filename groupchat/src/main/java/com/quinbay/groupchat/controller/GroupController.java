package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.Contacts;
//import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class GroupController {

//    @Autowired
//    Groups group;

    @Autowired
    GroupService groupService;

    @PostMapping("/createGroup")
     public ResponseEntity<Groups> addGroup(@RequestParam String groupname, @RequestParam String createdby, @RequestParam String userid){
        Groups createGroup = groupService.addGroup(groupname,createdby,userid);
        return ResponseEntity.status(HttpStatus.OK).body(createGroup);
    }

    @GetMapping("/showAllGroupsData")
    public List<Groups> showAllGroups(){
        return groupService.showAllGroups();
    }

    @GetMapping("/showGroup")
    public Map<Integer,Groups> getMembers(@RequestParam String mobilenum){
        return groupService.getMembers(mobilenum);
    }

    @DeleteMapping("/deleteGroup")
    public String deleteGroup(@RequestParam int groupid){
        return groupService.deleteGroup(groupid);
    }

}
