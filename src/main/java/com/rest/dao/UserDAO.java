package com.rest.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rest.model.*;

@Repository
public interface UserDAO  extends CrudRepository<User, Integer>{
	User findByName(String name);
	//List<User> findALL();
	User findById(Integer id);
}
