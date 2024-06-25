package com.exam.examServer;

import com.exam.examServer.Models.Role;
import com.exam.examServer.Models.User;
import com.exam.examServer.Models.UserRole;
import com.exam.examServer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamServerApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Starting code");
		
//		User user1 =new User();
//		user1.setFirstname("Rohit");
//		user1.setLastname("Rajput");
//		user1.setUsername("rohit7049");
//		user1.setPassword(this.bCryptPasswordEncoder.encode("abc"));
//		user1.setProfile("default.png");
//		user1.setEmail("abc@gmail.com");
//		user1.setPhone("7217750031");
//
//		Role role1=new Role();
//		role1.setRoleId(44L);
//		role1.setRoleName("ADMIN");
//
//
//
//
//		Set<UserRole> userRoleSet=new HashSet<>();
//		UserRole userRole=new UserRole();
//		userRole.setRole(role1);
//		userRole.setUser(user1);
//
//		userRoleSet.add(userRole);
//
//
//
//		User new_user=this.userService.createUser(user1,userRoleSet);
//		System.out.println(new_user.getUsername());
//
	}

}
