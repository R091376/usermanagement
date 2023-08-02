package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserEntity;
import com.example.demo.service.UserEntityService;

@RestController
@RequestMapping("/users")
public class UserEntityController {

	@Autowired
	private UserEntityService userService;
	
	@GetMapping
	public List<UserEntity> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public UserEntity getUserById(@PathVariable Long id) {
		return userService.getUserById(id);
	}
	
	@PostMapping
	public UserEntity saveUser(@RequestBody UserEntity user) {
		return userService.saveUser(user);
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable Long id) {
		userService.deleteUser(id);
	}
	
}
