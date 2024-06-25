package com.exam.examServer.repo;

import com.exam.examServer.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User,Long> {

   public  User findByUsername(String username);


}
