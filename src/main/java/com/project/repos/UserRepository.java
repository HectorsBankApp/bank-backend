package com.project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	User findUserByEmailAndPassword(String email, String password);

}
