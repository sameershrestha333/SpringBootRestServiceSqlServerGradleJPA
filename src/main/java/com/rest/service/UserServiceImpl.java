package com.rest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.rest.dao.UserDAO;
import com.rest.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDAO;

	@Override
	public User findByName(String name) {
		// TODO Auto-generated method stub
		return userDAO.findByName(name);
	}

	
	@HystrixCommand(fallbackMethod = "findAllFail")
	@Override
	public List<User> findALL() {

		int z = 5 / 0;

		return (List<User>) userDAO.findAll();

	}
	// method that is trigger after the fallback from findAll().
	public List<User> findAllFail() {
		System.out.println("Bingo");
		List<User> users = new ArrayList<>();
		users.add(new User("Bingo", 33));
		return users;
	}

	@Override
	public User findById(Integer id) {
		// TODO Auto-generated method stub
		return userDAO.findById(id);
	}

	@Override
	public User save(User user) {
		// TODO Auto-generated method stub
		return userDAO.save(user);
	}

	@Override
	public void delete(Integer id) {
		userDAO.delete(id);

	}

}
