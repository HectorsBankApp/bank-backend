package com.project.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.models.Account;
import com.project.services.AccountService;

@RestController
@RequestMapping("/accounts")
public class AccountController {
	
	private AccountService aserv;
	
	public AccountController(AccountService aserv) {
		this.aserv = aserv;
	}
	
	@GetMapping
	public List<Account> getAllAccounts() {
		return aserv.getAllAccounts();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<List<Account>> getAccountsByOwnerId(@PathVariable("id") int id) {
		
		Optional<List<Account>> accounts = aserv.getAccountbyOwnerId(id);
		
		if (!accounts.isPresent()) {
			return new ResponseEntity<List<Account>>(HttpStatus.NO_CONTENT);
		} else {
			return ResponseEntity.ok(accounts.get());
		}
	}
	
	@PostMapping
	public Account addAccount(Account a) {
		return aserv.addAccount(a);
	}
	
	@PutMapping
	public Account updateAccount(Account a) {
		return aserv.updateAccount(a);
	}
}
