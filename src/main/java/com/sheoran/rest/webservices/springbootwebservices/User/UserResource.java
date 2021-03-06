package com.sheoran.rest.webservices.springbootwebservices.User;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {

	@Autowired
	private UserDaoService service;

	@GetMapping(path = "/users")
	public List<User> getAllUsers() {
		return service.findAll();

	}

	@GetMapping(path = "/users/{id}")
	public User getUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if(null == user) {
			throw new UserNotFoundException("ID -"+id);
		}
		return user;

	}

	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@RequestBody User user) {

		User savedUser = service.save(user);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
}
