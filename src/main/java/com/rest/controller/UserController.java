package com.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.service.UserService;


@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	// Giving all the list of User with Get http().
	@GetMapping
	public List<User> getAllUser() {
		return userService.findALL();
	}

	// Giving respective User with given id in Get http().
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		return userService.findById(id);
	}

	// Add a User POST http().
	@PostMapping
	public User saveUser(@RequestBody User user) {
		String id= "";
		try {
			id=String.valueOf(user.getId());
			System.out.println("Data added successfully with id :" + id);
			return userService.save(user);
		} catch (Exception ex) {
			System.out.println("Error in adding movie." + ex.toString());
		}
		return null;
	}

}
