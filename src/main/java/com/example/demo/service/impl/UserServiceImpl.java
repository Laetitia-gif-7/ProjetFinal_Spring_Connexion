package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserDAO;
import com.example.demo.dto.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public UserDTO createUser(UserDTO userDTO) {
		//Transfert d'information du DTO vers l'Entity
		
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		
		User newUser = userDAO.save(user);
		
		//Transfert d'information de l'Entity vers le DTO
		BeanUtils.copyProperties(newUser, userDTO);
		return userDTO;
		
	}

	@Override
	public List<UserDTO> getAllUsers() {
		//liste des users de la bdd
		List <User> users = userDAO.findAll();
		
		//cette liste doit etre transférer dans une liste de UserDTO
		List<UserDTO> usersDTO = new ArrayList<>();
		
		for (User user : users) {
			UserDTO userDTO = new UserDTO();
			BeanUtils.copyProperties(user, userDTO);
			usersDTO.add(userDTO);
		}
		
		return usersDTO;
	}

}
