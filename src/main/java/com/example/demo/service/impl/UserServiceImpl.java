package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User createUser(User user) {
		User newUser = userDAO.save(user);
		return newUser;
		
	}

	@Override
	public List<User> getAllUsers() {
		return userDAO.findAll();
	}

}
