package com.project.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.models.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
	
	Optional<List<Account>> findAccountByOwner(int id);
}
