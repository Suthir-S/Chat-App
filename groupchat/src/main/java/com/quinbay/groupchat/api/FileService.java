package com.quinbay.groupchat.api;

import com.quinbay.groupchat.model.File;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

public interface FileService {
    String send(MultipartFile file , String senderid , int groupid) throws IOException;
    File getFile(String id) throws NoSuchElementException;
    Stream<File> getAllFiles();
}
