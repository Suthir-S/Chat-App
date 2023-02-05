//package com.quinbay.contacts.kafka;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.quinbay.contacts.model.Contacts;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class KafkaPublishingService {
//
//        @Autowired
//        ObjectMapper objectMapper;
//
//        @Autowired
//        KafkaTemplate kafkaTemplate;
//
//        public void ContactDetails (List<Contacts> contact){
//            //spring.kafka.consumer.group_id=contacts
//            try{
//                System.out.println("Kafka Publisher called");
//                kafkaTemplate.send("send.contactinfo",this.objectMapper.writeValueAsString(contact));
//            }
//            catch (Exception e){
//                System.out.println("Error Occurred"+e);
//            }
//        }
//    }
