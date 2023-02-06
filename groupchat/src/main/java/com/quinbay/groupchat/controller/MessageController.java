package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.model.MessageRequest;
import com.quinbay.groupchat.model.MessageResponse;
import com.quinbay.groupchat.service.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class MessageController {

    @Autowired
    MessageServiceImpl messageServiceImpl;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody MessageRequest newmsg) {
        return messageServiceImpl.newSendMessage(newmsg);
    }


    @GetMapping("/displayPagination/{page}/{size}")
    public Page<MessageResponse> getSpecificpage(@RequestParam int groupid, @RequestParam String userid, @PathVariable int page, @PathVariable int size){
        return messageServiceImpl.findSpecificPage(groupid,userid,page,size);
    }

    @GetMapping("/displaySpecific")
    public List<MessageResponse>  getSpecificRes(@RequestParam int groupid, @RequestParam String userid){
        return messageServiceImpl.findGroupMessageRes(groupid,userid);
    }

    @DeleteMapping("/deleteMessage")
    public String removeMessage(@RequestParam int messageid , @RequestParam String userid) {
        return messageServiceImpl.removeMessage(messageid,userid);
    }

    @GetMapping("/displayAllMessagesData")
    public List<Message> findAllData(){
        return messageServiceImpl.showAllGroups();
    }

}

//=====
//@DeleteMapping("/clearChat")
//public void deleteAll(){
//    messageServiceImpl.clearChat();
//}
