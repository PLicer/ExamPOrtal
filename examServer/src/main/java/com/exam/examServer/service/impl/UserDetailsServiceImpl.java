package com.exam.examServer.service.impl;

import com.exam.examServer.Models.User;
import com.exam.examServer.repo.UserRepository;
import com.exam.examServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user= userRepository.findByUsername(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("No user found");
        }
        return user;
    }
}
