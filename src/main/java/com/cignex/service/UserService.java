package com.cignex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cignex.model.User;
import com.cignex.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public User save(User user) {
		return userRepository.save(user);
	}

	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	public void delete(int id) {
		userRepository.deleteById(id);
	}
	
	public User login(String email,String password) {
		return userRepository.findByEmailAndPassword(email,password);
	}
}
