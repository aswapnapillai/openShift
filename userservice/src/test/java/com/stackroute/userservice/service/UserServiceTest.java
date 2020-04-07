package com.stackroute.userservice.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.exception.UserAlreadyExistsException;
import com.stackroute.userservice.exception.UserNotFoundException;
import com.stackroute.userservice.repository.UserRepository;



import junit.framework.Assert;



public class UserServiceTest {

	@Mock
	private UserRepository userRepository;
	private User user;
	
	@InjectMocks
	private UserServiceImpl userService;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		user = new User();
		user.setUsername("Johan");
		user.setPassword("123");
		
	}
	@Test
	public void testSaveUserSuccess() throws UserAlreadyExistsException
	{
		Mockito.when(userRepository.save(user)).thenReturn(user);
		
		User userObj = userService.registerUser(user);
		Assert.assertEquals(user, userObj);
		verify(userRepository,times(1)).save(user);
		
	}
	
	@Test
	public void testFindByUserNameAndPassword() throws UserNotFoundException
	{
		Mockito.when(userRepository.findByUsernameAndPassword(user.getUsername(),user.getPassword())).thenReturn(user);
		User userObj = userService.findByUserNameAndPassword(user.getUsername(),user.getPassword());
		Assert.assertEquals(user.getUsername(), userObj.getUsername());
		verify(userRepository,times(1)).findByUsernameAndPassword(user.getUsername(),user.getPassword());;
	}
	
	
}
