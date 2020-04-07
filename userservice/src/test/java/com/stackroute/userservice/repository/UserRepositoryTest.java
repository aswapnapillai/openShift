package com.stackroute.userservice.repository;

import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.stackroute.userservice.domain.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
@Autowired
private UserRepository  userRepository;

private User user;

@Before
public void setUp()
{
	user = new User();
	user.setUsername("nav");
	user.setPassword("nav1");
}

@After
public void tearDown()
{
	userRepository.deleteAll();
	user = null;
	
	}

	@Test
	public void testRegisterUserSuccess()
	{
		userRepository.save(user);
		Optional<User> userObj = userRepository.findById(user.getUsername());
		userRepository.delete(user);
	}
	
	@Test
	public void testUserLoginSuccess()
	{
		userRepository.save(user);

		User userObj = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
		Assert.assertEquals(user.getUsername(), userObj.getUsername());
		userRepository.delete(user);
		
	}
}


