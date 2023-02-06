package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.*;
import com.quinbay.groupchat.service.GroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
public class GroupController {


    @Autowired
    GroupServiceImpl groupServiceImpl;

    @PostMapping("/createGroup")
     public ResponseEntity<GroupsResponse> addGroup(@RequestParam String groupname, @RequestParam String createdby, @RequestParam String userid){
        Groups createGroup = groupServiceImpl.addGroup(groupname,createdby,userid);
        GroupsResponse response = new GroupsResponse(createGroup.getId(),createGroup.getGroupname(),createGroup.getCreatedby(),createGroup.getCreatedon());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/showAllGroupsData")
    public List<GroupsResponse> showAllGroups(){
        return groupServiceImpl.showAllGroups();
    }


    @GetMapping("/showGroup")
    public Map<Integer,GroupsResponse> getMembersRes(@RequestParam String mobilenum){
        return groupServiceImpl.getMembers(mobilenum);
    }

    @DeleteMapping("/deleteGroup")
    public String deleteGroup(@RequestParam int groupid){
        return groupServiceImpl.deleteGroup(groupid);
    }

}
