package com.rest.service;

import java.util.List;

import com.rest.model.User;


public interface UserService {
	//CRUD
	
	//C and U
	User save(User user);
	//D
	void delete(Integer id);
	//R
	User findByName(String name);
	List<User> findALL();
	User findById(Integer id);
}
