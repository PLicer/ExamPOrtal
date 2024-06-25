package com.exam.examServer.service;

import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;
import org.springframework.stereotype.Service;

import java.util.Set;
@Service
public interface UserService {

    public User createUser(User user, Set<UserRole>userRoles) throws Exception;

    User getUser(String username);

    void deleteUser(Long userId);
}
