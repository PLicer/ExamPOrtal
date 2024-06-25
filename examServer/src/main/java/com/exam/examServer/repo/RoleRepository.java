package com.exam.examServer.repo;

import com.exam.examServer.Models.Role;
import com.exam.examServer.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}
