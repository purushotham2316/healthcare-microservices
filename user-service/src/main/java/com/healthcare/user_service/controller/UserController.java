package com.healthcare.user_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.user_service.model.User;
import com.healthcare.user_service.service.UserService;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/fetchallusers")
	public List<User> getAllUsers() {
    List<User> users = userService.getAllUsers();
        System.out.println(users);
        return users;
    }
	
	@PostMapping("/createuser")
	public User createuser(@RequestBody User user) {
		
		return userService.createuser(user);
	}
	
	@GetMapping("/{email}")
	public List<User> getUserByEmail(@PathVariable("email") String email)
	{
		return userService.getUserByEmail(email);
	}

}
