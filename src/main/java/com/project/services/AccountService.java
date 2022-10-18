package com.project.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.project.enums.Status;
import com.project.models.Account;
import com.project.repos.AccountRepository;

@Service
public class AccountService {
	
	private AccountRepository accRepo;	
	
	public AccountService(AccountRepository accRepo) {
		this.accRepo = accRepo;
	}
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public Account addAccount(Account a) {
		a.setStatus(Status.Pending);
		return accRepo.save(a);
	}
	
	@Transactional(readOnly=true)
	public List<Account> getAllAccounts() {
		return accRepo.findAll();	 
	}
	
	@Transactional(readOnly=true)
	public Optional<List<Account>> getAccountbyOwnerId(int id) {
		return accRepo.findAccountByOwner(id);
	}
	
	public Account updateAccount(Account a) {
		return accRepo.save(a);
	}
	
	public void deleteAccount(Account a) {
		accRepo.delete(a);
	}
	
	

}
