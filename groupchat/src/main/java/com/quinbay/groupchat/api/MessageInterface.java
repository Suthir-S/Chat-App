package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.model.MessageRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageInterface {
   String newSendMessage(MessageRequest newmsg);
   List<Message> findGroupMessage(int groupid,String userid);
   Page<Message> findSpecific(int groupid, String userid,int page, int size);
   String removeMessage(int messageid,String userid);
   List<Message> showAllGroups();
}


//=======
//void clearChat();