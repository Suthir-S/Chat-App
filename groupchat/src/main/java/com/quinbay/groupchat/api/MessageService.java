package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.Message;
import com.quinbay.groupchat.model.MessageRequest;
import com.quinbay.groupchat.model.MessageResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface MessageService {
   String newSendMessage(MessageRequest newmsg);
   List<MessageResponse> findGroupMessageRes(int groupid, String userid);
   Page<MessageResponse> findSpecificPage(int groupid, String userid,int page, int size);
   String removeMessage(int messageid,String userid);
   List<Message> showAllGroups();
}


//=======
//void clearChat();