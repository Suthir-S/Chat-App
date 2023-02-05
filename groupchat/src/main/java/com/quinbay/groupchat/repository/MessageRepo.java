package com.quinbay.groupchat.repository;

import com.quinbay.groupchat.model.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepo extends PagingAndSortingRepository<Message,Integer> {
     List<Message> findAll();
     //List<Message> findByGroupid(String groupid);
     Message findByMessageid(int messageid);
     List<Message> findByGroupidAndUserid(int groupid,String userid);
     Page<Message> findByGroupidAndUserid(int groupid,String userid,Pageable page);
//     List<Message> findByGroupidOrderByMessageidDesc(int groupid); //not working
}

/*

pageable = PageRequest.of(page, size, Sort.by("level").descending());
tutorials = tutorialRepository.findByPublished(false, pageable).getContent();

 */