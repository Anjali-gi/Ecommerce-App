package com.ecommerceapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceapp.entity.User;
import com.ecommerceapp.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public User getUserById(Long id) {
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + "not found"));
	}
	
	public void createUser(User user) {
		userRepo.save(user);
	}

	public void updateUser(User User, Long id) {
		userRepo.findById(User.getId())
				.orElseThrow(() -> new RuntimeException("user with id " + User.getId() + "not found"));
		userRepo.save(User);
	}

	public void deleteUser(Long id) {
		userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + "not found"));
		userRepo.deleteById(id);
	}
	
	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public boolean verifyCredentials(String email, String password) {
		User User = userRepo.findByEmail(email);
		if (User.getPassword() == password) {
			return true;
		}
		return false;
	}

}
