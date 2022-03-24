package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.UserDTO;
import com.example.demo.service.UserService;

@RestController
public class UserApiREST {

	@Autowired
	private UserService userService;
	
	@GetMapping(path = "/allUsers")
	public List<UserDTO> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PostMapping(path = "/createUser")
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
		
		UserDTO newUserDTO = userService.createUser(userDTO);
		
		return new ResponseEntity<UserDTO>(newUserDTO, HttpStatus.OK);
	}
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Void> deleteUserById(@PathVariable Integer id) {
		
		userService.deleteUserById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping(path = "/users/{id}")
	public ResponseEntity<UserDTO> updateUser(@PathVariable Integer id, @RequestBody UserDTO userDTO) {
		UserDTO useDTO = userService.updateUser(id, userDTO);
		
		return new ResponseEntity<UserDTO>(useDTO, HttpStatus.OK);
	}
}
