package com.exam.examServer.controller;

import com.exam.examServer.Models.JwtRequest;
import com.exam.examServer.Models.JwtResponse;
import com.exam.examServer.Models.User;
import com.exam.examServer.config.JwtUtil;
import com.exam.examServer.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@CrossOrigin("*")
public class AuthenticateController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        try{

            authenticate(jwtRequest.getUsername(),jwtRequest.getPassword());

        }
        catch (UsernameNotFoundException ex)
        {
            ex.printStackTrace();
            throw  new Exception("user not found");
        }

        UserDetails userDetails=this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token=this.jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));

    }




    private void authenticate(String username,String password) throws Exception {
        try{

            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));

        }
        catch (DisabledException ex)
        {
            throw new Exception("User Disabled"+ex.getMessage());

        }
        catch (BadCredentialsException ex)
        {
            throw new Exception("Invalid Credentials"+ ex.getMessage());
        }

    }

    @GetMapping("/current-user")
    public User getCurrentUser(Principal principal)
    {
        return ((User)this.userDetailsService.loadUserByUsername(principal.getName()));
    }

}
