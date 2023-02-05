package com.quinbay.groupchat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupsResponse {
    Integer id;
    String groupName;
    String createdBy;
    Date createdOn;
}
