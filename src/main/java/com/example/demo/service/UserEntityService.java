package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.exception.DuplicateUsernameException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.UserEntity;
import com.example.demo.repository.UserEntityRepository;

@Service
public class UserEntityService {

	@Autowired
	private UserEntityRepository userRepository;
	
	public List<UserEntity> getAllUsers(){
		return (List<UserEntity>) userRepository.findAll();
	}
	
	public UserEntity getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	public UserEntity saveUser(UserEntity user) {
		try {
			return userRepository.save(user);
		}catch(DataIntegrityViolationException e) {
			throw new DuplicateUsernameException("an entry with provided username already exist in database");
		}
	}
	
	public void deleteUser(Long id) {
		try {
			userRepository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new UserNotFoundException("user does not exist with provided id");
		}
	}
}
