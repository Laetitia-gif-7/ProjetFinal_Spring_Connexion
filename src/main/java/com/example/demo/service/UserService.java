package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.UserDTO;




public interface UserService {
	
	public UserDTO createUser(UserDTO user);
	
	public List<UserDTO> getAllUsers();
}
