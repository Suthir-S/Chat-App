package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface FileRepo extends JpaRepository<File,String> {
    List<File> findByGroupid(int groupid);
}
