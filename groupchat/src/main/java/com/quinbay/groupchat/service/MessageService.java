package com.quinbay.groupchat.service;


import com.quinbay.groupchat.api.MessageInterface;
import com.quinbay.groupchat.model.GroupMembers;
import com.quinbay.groupchat.model.Groups;
import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.model.MessageRequest;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import com.quinbay.groupchat.repository.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService implements MessageInterface {

    @Autowired
    MessageRepo messageRepo;

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Autowired
    GroupRepo groupRepo;

    @Override
    public String newSendMessage(MessageRequest newmsg) { //grpid,sendernum,msgtext
        Groups grpPresent = groupRepo.findById(newmsg.getGroupId());
        if (grpPresent != null) {
            GroupMembers check = groupMembersRepo.findByUseridAndGroupId(newmsg.getSenderId(), newmsg.getGroupId());
            List<GroupMembers> sendMessage = groupMembersRepo.findByGroupid(newmsg.getGroupId());
            int messageid=0;
            if (check != null) {
                for (GroupMembers mems : sendMessage) {
                    Message newaddmsg = new Message();
                    newaddmsg.setSenderid(newmsg.getSenderId());
                    newaddmsg.setGroupid(newmsg.getGroupId());
                    newaddmsg.setMessagetext(newmsg.getMessageText());
                    newaddmsg.setUserid(mems.getUserid());
//                    newaddmsg.setGroupmembers(check);
                    messageRepo.save(newaddmsg);
                    if(mems.getUserid().equals(newmsg.getSenderId())){
                        messageid = newaddmsg.getMessageid();
                    }
                }
                return "Message Sent\nMessage id :"+messageid+" ";
            }
            return "Member doesn't Exists";
        }
        return "Group doesn't Exists";
    }

    @Override
    public String removeMessage(int messageid,String userid){
        Message fetchmessage = messageRepo.findByMessageid(messageid);
        if(fetchmessage!=null) {
            if (fetchmessage.getUserid().equals(userid)) {
                messageRepo.delete(fetchmessage);
                return "Message deleted";
            }
        }
        return "Message doesn't exists";
    }

    @Override
    public List<Message> findGroupMessage(int groupid,String userid) {
        List<Message> message = messageRepo.findByGroupidAndUserid(groupid,userid);
//        for(Message msg:message){
//            System.out.println(msg.getGroupmembers().getUserid());
//        }
        return message;
    }


    @Override
    public Page<Message> findSpecific(int groupid, String userid, int page, int size) {
        Pageable pages = PageRequest.of(page,size);
        Page<Message> message = messageRepo.findByGroupidAndUserid(groupid,userid,pages);
        return message;
    }


    @Override
    public List<Message> showAllGroups(){
        return messageRepo.findAll();
    }

}

//=========

//@Override
//    public void clearChat() {
//        messageRepo.deleteAll();
//    }