package com.project.controllers;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.User;
import com.project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	private UserService userv;

	public UserController(UserService userv) {
		this.userv = userv;
	}
	
	@GetMapping
	public List<User> getAllUsers() {
		return userv.getAllUsers();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int id ) {
		
		Optional<User> user = userv.findUserById(id);
		
		if (!user.isPresent()) {
			return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
		} else {
			return ResponseEntity.ok(user.get());
		}
	}
	
	@PostMapping
	public User register(@Valid @RequestBody User u) {
		return userv.addUser(u);
	}
	
	@PutMapping
	public User updateUser(@Valid @RequestBody User u) {	
		return userv.updateUser(u);
	}

}
