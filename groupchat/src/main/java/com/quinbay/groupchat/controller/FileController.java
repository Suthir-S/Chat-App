package com.quinbay.groupchat.controller;

import com.quinbay.groupchat.model.File;
import com.quinbay.groupchat.model.FileResponse;
import com.quinbay.groupchat.service.FileServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import java.util.List;
import java.util.stream.Collectors;

@Controller
@RestController
@CrossOrigin(origins = "*")
public class FileController {

    @Autowired
    private FileServiceImpl fileServiceImpl;

    @PostMapping("/sendFile")
    public String sendFile(@RequestParam("file") MultipartFile file, @RequestParam String senderid, @RequestParam int groupid) {
        String message = "";
        try {

            return fileServiceImpl.send(file, senderid, groupid);
        } catch (Exception e) {
            return "Could not send the file: " + file.getOriginalFilename() + "!";
        }
    }

    @GetMapping("/displayAllFiles")
    public ResponseEntity<List<FileResponse>> getListFiles() {
        List<FileResponse> files = fileServiceImpl.getAllFiles().map(dbFile -> {
            String downloadFile = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/displayAllFiles/")
                    .path(dbFile.getId())
                    .toUriString();

            return new FileResponse(
                    dbFile.getName(),
                    dbFile.getGroupid(),
                    downloadFile,
                    dbFile.getType(),
                    dbFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(files);
    }

    @GetMapping("/download/{fileid}")
    public ResponseEntity<byte[]> getFile(@PathVariable String fileid) {
        File fileDB = fileServiceImpl.getFile(fileid);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getName() + "\"")
                .body(fileDB.getData());
    }

    @DeleteMapping("/deleteFile")
    public String deleteFile(@RequestParam String id) {
        return fileServiceImpl.deleteFile(id);
    }

    @GetMapping("/FilesByGroupid")
    public ResponseEntity<List<FileResponse>> findGroupFiles(int groupid){
        List<FileResponse> grpFiles = fileServiceImpl.findGroupFiles(groupid).map(dbGrpFile -> {
            String fileDownloadUri = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/FilesByGroupid/")
                    .path(dbGrpFile.getId())
                    .toUriString();

            return new FileResponse(
                    dbGrpFile.getName(),
                    dbGrpFile.getGroupid(),
                    fileDownloadUri,
                    dbGrpFile.getType(),
                    dbGrpFile.getData().length);
        }).collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(grpFiles);
    }
}













//    @GetMapping("/FilesByGroupid")
//    public ResponseEntity<List<FileResponse>> findGroupFiles(int groupid){
//        List<FileResponse> files = fileServiceImpl.findGroupFiles(groupid).map(dbFile -> {
//            String fileDownloadUri = ServletUriComponentsBuilder
//                    .fromCurrentContextPath()
//                    .path("/displayFiles/")
//                    .path(dbFile.getId())
//                    .toUriString();
//
//            return new FileResponse(
//                    dbFile.getName(),
//                    fileDownloadUri,
//                    dbFile.getType(),
//                    dbFile.getData().length);
//        }).collect(Collectors.toList());
//
//        return ResponseEntity.status(HttpStatus.OK).body(files);
//    }


