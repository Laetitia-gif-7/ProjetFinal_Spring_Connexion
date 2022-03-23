package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;

@SpringBootApplication
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
