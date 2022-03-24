package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FinalSpringProjectApplication implements CommandLineRunner{
	
	@Autowired
	UserService service;

	public static void main(String[] args) {
		SpringApplication.run(FinalSpringProjectApplication.class, args);
	}
	



	@Override
	public void run(String... args) throws Exception {
		UserDTO user = new UserDTO("Jordan", "jordan***");
		service.createUser(user);
		user = new UserDTO("Vina", "vina***");
		service.createUser(user);
		
		System.out.println(service.getAllUsers());
	}

}
