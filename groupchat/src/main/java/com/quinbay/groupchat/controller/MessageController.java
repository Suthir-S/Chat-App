package com.quinbay.groupchat.controller;


import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.model.MessageRequest;
import com.quinbay.groupchat.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/sendMessage")
    public String sendMessage(@RequestBody MessageRequest newmsg) {
        return messageService.newSendMessage(newmsg);
    }

    @GetMapping("/displayPagination/{page}/{size}")
    public Page<Message> getSpecific(@RequestParam int groupid, @RequestParam String userid, @PathVariable int page, @PathVariable int size){
        return messageService.findSpecific(groupid,userid,page,size);
    }



    @GetMapping("/displaySpecific")
    public List<Message>  getSpecific(@RequestParam int groupid,@RequestParam String userid){
        return messageService.findGroupMessage(groupid,userid);
    }



    @DeleteMapping("/deleteMessage")
    public String removeMessage(@RequestParam int messageid , @RequestParam String userid) {
        return messageService.removeMessage(messageid,userid);
    }

    @GetMapping("/displayAllMessagesData")
    public List<Message> findAllData(){
        return messageService.showAllGroups();
    }

}

//=====
//@DeleteMapping("/clearChat")
//public void deleteAll(){
//    messageService.clearChat();
//}
