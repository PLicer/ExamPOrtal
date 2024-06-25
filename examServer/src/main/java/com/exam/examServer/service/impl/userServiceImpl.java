package com.exam.examServer.service.impl;

import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;
import com.exam.examServer.repo.RoleRepository;
import com.exam.examServer.repo.UserRepository;
import com.exam.examServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class userServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public User createUser(User user, Set<UserRole> userRoles) throws Exception{

        User local=this.userRepository.findByUsername(user.getUsername());
        if(local!=null)
        {
            System.out.println("User is already there");
            throw new Exception("User already present !!!");
        }
        else {
            for(UserRole ur:userRoles)
            {
                roleRepository.save(ur.getRole());
            }
            user.getUserRoles().addAll(userRoles);
           local= this.userRepository.save(user);
        }
        return local;
    }

    @Override
    public User getUser(String username) {
        return this.userRepository.findByUsername(username);
    }



    @Override
    public void deleteUser(Long userId) {

        this.userRepository.deleteById(userId);

    }
}
