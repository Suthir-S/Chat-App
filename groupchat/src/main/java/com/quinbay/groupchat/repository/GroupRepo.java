package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepo extends JpaRepository<Groups,Integer> {
    //Groups findByGroupname(int groupname);
    Groups findById(int groupid);
}
