package com.quinbay.groupchat.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;


import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Id
    @SequenceGenerator(name = "messages" , sequenceName = "messages", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE , generator = "messages")
    Integer messageid;
    String senderid;
    Integer groupid;
    String messagetext;
    @CreationTimestamp
    Date timestamp;
    String userid;

//    @ManyToOne
//    @JoinColumn(name = "group_member_id",referencedColumnName = "memberid")
//    @JsonIgnore
//    GroupMembers groupmembers;

    public Message(int groupid, String senderid, String messagetext,String userid) {
        this.senderid = senderid;
        this.groupid = groupid;
        this.messagetext = messagetext;
        this.userid = userid;
    }
}
