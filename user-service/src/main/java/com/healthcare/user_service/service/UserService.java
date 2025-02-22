package com.healthcare.user_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.user_service.model.User;
import com.healthcare.user_service.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	
	//Fetches all users.
	public List<User> getAllUsers() {
		List<User> users = userRepository.findAll();
		System.out.println(users);
		 // Check if users list is actually populated
//        if (users.isEmpty()) {
//            System.out.println("No users found in the database!");
//        } else {
//            System.out.println("Users retrieved: " + users);
//        }

        return users;
    }
	
	//Fetches a specific user.
	public List<User> getUserByEmail(String email)
	{
		return userRepository.findByEmail(email);
	}
	
	//Saves a new user.
	public User createuser(User user)
	{
		return userRepository.save(user);
	}
}
