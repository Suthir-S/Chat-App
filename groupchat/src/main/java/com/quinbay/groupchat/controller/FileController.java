package com.quinbay.groupchat.controller;

import com.quinbay.groupchat.model.File;
import com.quinbay.groupchat.model.ResponseFile;
import com.quinbay.groupchat.service.FileService;
import com.sun.istack.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/sendFile")
    public String sendFile(@RequestParam("file") MultipartFile file, @RequestParam String senderid , @RequestParam int groupid){
        String message = "";
        try {

            return fileService.send(file,senderid,groupid);
        } catch (Exception e) {
            return "Could not send the file: " + file.getOriginalFilename() + "!";
        }
    }

    @GetMapping("/displayFiles")
    public ResponseEntity<List<ResponseFile>> getListFiles() {
        List<ResponseFile> files = fileService.getAllFiles().map(dbFile -> {
            String downloadFile = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/displayFiles/")
                    .path(dbFile.getId())
                    .toUriString();

            return new ResponseFile(
                    dbFile.getName(),
                    downloadFile,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/download/{fileid}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileid) {
            File fileDB = fileService.getFile(fileid);
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                    .body(fileDB.getData());
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestParam String id){
        return fileService.deleteFile(id);
    }

//    @GetMapping("/FilesByGroupid")
//    public ResponseEntity<List<ResponseFile>> findGroupFiles(int groupid){
//        List<ResponseFile> files = fileService.findGroupFiles(groupid).map(dbFile -> {
//            String fileDownloadUri = ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/displayFiles/")
//                    .path(dbFile.getId())
//                    .toUriString();
//
//            return new ResponseFile(
//                    dbFile.getName(),
//                    fileDownloadUri,
//                    dbFile.getType(),
//                    dbFile.getData().length);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//    }

}

