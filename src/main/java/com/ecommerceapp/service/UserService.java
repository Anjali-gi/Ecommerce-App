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
		return userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
	}

	public void createUser(User user) {
		userRepo.save(user);
	}
/**
	public void updateUser(User User) {
		userRepo.findById(User.getId()).orElseThrow(() -> new RuntimeException("User with id " + User.getId() + " not found"));
		userRepo.save(User);
	}
**/


	public void updateUser(User user) {
		User existingUser = userRepo.findById(user.getId())
				.orElseThrow(() -> new RuntimeException("User with id " + user.getId() + " not found"));

		// Retain the existing password if it's not provided in the update request
		if (user.getPassword() == null || user.getPassword().isEmpty()) {
			user.setPassword(existingUser.getPassword());
		}

		userRepo.save(user);
	}




	public void deleteUser(Long id) {
		userRepo.findById(id).orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
		userRepo.deleteById(id);
	}

	public User findUserByEmail(String email) {
		return userRepo.findByEmail(email);
	}

	public boolean verifyCredentials(String email, String password) {
		User user = userRepo.findByEmail(email);
		if (user == null) {
			throw new RuntimeException("User with email " + email + " not found");
		}

		if (user.getPassword().equals(password)) {
			return true;
		}

		return false;
	}

}