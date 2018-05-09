package com.teste.restController;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.User;
import com.teste.repository.UserRepository;

@RestController
public class UserRestController {
	
	@Autowired
    UserRepository userepository;

	@GetMapping("/users")
	public List<User> getUsers() {		
		return this.userepository.findAll();
	}
	
	@GetMapping("/usersAll")
	public List<User> getUsersAll() {
		List<User> users = new ArrayList<>();
		users.add(new User("Eloiza", "Santos"));
		users.add(new User("Marcelo", "Cardoso"));
		return users;
	}
}
