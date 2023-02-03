//package com.quinbay.groupchat.kafka;
//
//import com.fasterxml.jackson.core.type.TypeReference;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.quinbay.groupchat.model.Contacts;
//import com.quinbay.groupchat.service.GroupMembersService;
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.annotation.KafkaListener;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class KafkaListeningService {
//
//        @Autowired
//        ObjectMapper objectMapper;
//
//        @Autowired
//        GroupMembersService groupMembersService;
//
//        @KafkaListener(topics = "send.contactinfo",groupId = "contacts")
//        public void getWholesalerInfo (ConsumerRecord<?,String> consumerRecord){
//            List<Contacts> contact = null ;
//            try{
//                contact = objectMapper.readValue(consumerRecord.value(),
//                        new TypeReference<List<Contacts>>(){
//                        });
//                groupMembersService.contactslist(contact);
//            }catch (Exception e){
//
//            }
//        }
//    }
//
