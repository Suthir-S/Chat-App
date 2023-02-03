//package com.quinbay.groupchat.kafka;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.quinbay.groupchat.model.GroupMembers;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class KafkaPublishingService {
//
//    @Autowired
//    ObjectMapper objectMapper;
//
//    @Autowired
//    KafkaTemplate kafkaTemplate;
//
//    public void GroupDetails (List<GroupMembers> GroupMembers){
//        //spring.kafka.consumer.group_id=contacts
//        try{
//            System.out.println("Kafka Publisher called");
//            kafkaTemplate.send("send.contactinfo",this.objectMapper.writeValueAsString(GroupMembers));
//        }
//        catch (Exception e){
//            System.out.println("Error Occurred"+e);
//        }
//    }
//}
