package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;



public interface UserService {
	
	public User createUser(User user);
	
	public List<User> getAllUsers();
}