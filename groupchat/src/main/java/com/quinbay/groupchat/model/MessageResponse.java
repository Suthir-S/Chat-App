package com.quinbay.groupchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {
    Integer messageid;
    String senderid;
    Integer groupid;
    String messagetext;
    Date timestamp;
    String userid;
}
