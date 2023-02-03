package com.quinbay.chatlogin.repository;


import com.quinbay.chatlogin.model.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailsRepo extends JpaRepository<UserDetails,Integer> {
    UserDetails findById(int userId);
    UserDetails findByMobilenumAndPassword(String mobileNum,String password);
}
