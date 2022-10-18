package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.dto.Credentials;
import com.project.enums.Role;
import com.project.models.User;
import com.project.repos.UserRepository;

@Service
public class UserService {
	
	private UserRepository uRepo;
	
	public UserService(UserRepository repo) {
		this.uRepo = repo;
	}
	
	// Get all users
	@Transactional(readOnly=true)
	public List<User> getAllUsers() {
		return uRepo.findAll();
	}
	
	@Transactional(readOnly=true)
	public Optional<User> findUserById(int id) {
		return uRepo.findById(id);
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public User addUser(User u) {
		u.setRole(Role.Customer);	
		return uRepo.save(u);
	}
	
	public User login(String email, String password) {
		
		return uRepo.findUserByEmailAndPassword(email, password);
	}
	
	public void deleteUser(int id) {
		uRepo.deleteById(id);;
	}
	
	public User updateUser(User u) {
		return uRepo.save(u);
	}

}
