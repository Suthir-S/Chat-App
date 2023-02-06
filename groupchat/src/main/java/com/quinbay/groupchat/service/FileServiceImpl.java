package com.quinbay.groupchat.service;

import com.quinbay.groupchat.api.FileService;
import com.quinbay.groupchat.model.*;
import com.quinbay.groupchat.repository.FileRepo;
import com.quinbay.groupchat.repository.GroupMembersRepo;
import com.quinbay.groupchat.repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;

@Service
@Transactional
public class FileServiceImpl implements FileService {

    @Autowired
    FileRepo fileRepo;

    @Autowired
    GroupRepo groupRepo;

    @Autowired
    GroupMembersRepo groupMembersRepo;

    @Override
    public String send(MultipartFile file ,String senderid , int groupid) throws IOException{
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        Groups grpPresent = groupRepo.findById(groupid);
        if (grpPresent != null) {
            GroupMembers check = groupMembersRepo.findByUseridAndGroupId(senderid,groupid);
            if (check != null) {
                    File newaddfile = new File(fileName,file.getContentType(),file.getBytes(),groupid,senderid);
                    fileRepo.save(newaddfile);
                    return newaddfile.getId();
                }
            return "Member doesn't Exists";
            }
        return "Group doesn't Exists";
    }

    @Override
    public File getFile(String id) throws NoSuchElementException {
        Optional<File> fetch = fileRepo.findById(id);
        if (fetch.isPresent()) {
            return fetch.get();
        } else {
            File empty = new File();
            return empty;
        }
    }

    @Override
    public Stream<File> getAllFiles() {
        return fileRepo.findAll().stream();
    }

    @Override
    public String deleteFile(String id) {
        Optional<File> fetch = fileRepo.findById(id);
        if (fetch.isPresent()) {
            fileRepo.deleteById(id);
            return "File Deleted";
        }
        return "File doesn't Exists";
    }

//    @Override
    public Stream<File> findGroupFiles(int groupid) {
        return fileRepo.findByGroupid(groupid).stream();
        //return message;
    }

}
