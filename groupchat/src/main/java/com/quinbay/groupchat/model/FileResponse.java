package com.quinbay.groupchat.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FileResponse {
    String name;
    Integer groupid;
    String url;
    String type;
    long size;
}
