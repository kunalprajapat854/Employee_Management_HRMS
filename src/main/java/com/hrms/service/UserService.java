package com.hrms.service;

import java.util.List;

import com.hrms.entities.user;

public interface UserService {

	public void authenticate(String username, String passoword);

	public String createuser(user user);

	public void assignRole(Long userId, user user);

	public user getByUserId(Long userId);

	public List<user> getAllUsers();

}
