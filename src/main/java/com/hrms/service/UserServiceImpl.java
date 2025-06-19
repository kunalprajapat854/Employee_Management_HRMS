package com.hrms.service;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrms.entities.user;
import com.hrms.repository.core.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository;

	@Override
	public void authenticate(String username, String passoword) {
		user byUsername = repository.findByUsername(username);
		if (!passoword.equals(byUsername.getPassword())) {
			throw new RuntimeException("Invalid Password");
		}
		System.out.println("Authenticated " + username);

	}

	@Override
	public String createuser(user user) {
		com.hrms.entities.user userSaved = repository.save(user);
		if (userSaved != null) {
			return "User Saved";
		}
		return "Not saved internal error";
	}

	@Override
	public void assignRole(Long userId, user userWithNewrole) {
		Optional<com.hrms.entities.user> byId = repository.findById(userId);
		if (byId.isPresent()) {
			com.hrms.entities.user existingUser = byId.get();
			existingUser.setRole(userWithNewrole.getRole());

			repository.save(existingUser);
		} else {
			throw new RuntimeException("User is not found with Id " + userId);
		}

	}

	@Override
	public user getByUserId(Long userId) {
		Optional<user> ById = repository.findById(userId);
		if (ById.isPresent()) {
			return ById.get();
		}
		return null;
	}

	@Override
	public List<user> getAllUsers() {
		List<user> allUsers = repository.findAll();
		return allUsers;
	}

}
