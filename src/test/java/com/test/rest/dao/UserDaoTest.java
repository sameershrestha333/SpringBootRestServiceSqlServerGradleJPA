package com.test.rest.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.SpringBootRestServiceSqlServerGradleJpaApplication;
import com.rest.dao.UserDAO;
import com.rest.model.*;

@RunWith(SpringRunner.class)
@SpringBootTest
//@ContextConfiguration(classes={SpringBootRestServiceSqlServerGradleJpaApplication.class})
public class UserDaoTest {
	@Autowired
	private UserDAO userDAO;

	@Before
	public void setUp() throws Exception {
		User user1=new User("John", 26);
		User user2=new User("Bob", 33);
		//save user, verify has Id value after save
		assertNull(user1.getId());
		assertNull(user2.getId());
		this.userDAO.save(user1);
		this.userDAO.save(user2);
		assertNotNull(user1.getId());
		assertNotNull(user2.getId());

	}

	@Test
	public void testFetchData() {
		// Test data retrieval
		User userA=userDAO.findByName("John");
		assertNotNull(userA);
		assertEquals(26, userA.getAge());
		
		//get All user, list should only have 2
		List<User> users=(List<User>) userDAO.findAll();
		int count=0;
		for(User p: users) {
			count++;
		}
		assertEquals(count, 2);
	}

}
