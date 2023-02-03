package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.GroupMembers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GroupMembersRepo extends JpaRepository<GroupMembers,Integer> {
    GroupMembers findByUseridAndGroupId(String userid,int groupid); //specific memberid can be found
    List<GroupMembers> findByUserid(String mobilenum); //multiple groups list
    List<GroupMembers> findByGroupid(int groupid);
//    Map<String,Integer> findByGroupid(String contact, int groupid);
}
