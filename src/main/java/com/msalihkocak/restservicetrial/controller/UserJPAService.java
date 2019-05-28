package com.msalihkocak.restservicetrial.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.msalihkocak.restservicetrial.dao.PostRepository;
import com.msalihkocak.restservicetrial.dao.UserRepository;
import com.msalihkocak.restservicetrial.exception.UserNotFoundException;
import com.msalihkocak.restservicetrial.model.Post;
import com.msalihkocak.restservicetrial.model.User;

@RestController
public class UserJPAService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}
	
	@GetMapping("/jpa/users/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent())
			throw new UserNotFoundException("id-"+id);
		
		Resource<User> resource = new Resource<User>(user.get());
		
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		
		resource.add(linkTo.withRel("all-users"));
		
		return resource;
	}
	
	@PostMapping("/jpa/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User newUser = userRepository.save(user);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
												  .path("/{id}")
												  .buildAndExpand(newUser.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/jpa/users/{userId}")
	public void deleteUser(@PathVariable int userId) {
		userRepository.deleteById(userId);
	}
	
	@GetMapping("/jpa/users/{userId}/posts")
	public List<Post> getAllPostsOfUser(@PathVariable int userId) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("id-" + userId);
		return user.orElse(new User()).getPosts();
	}
	
	@PostMapping("/jpa/users/{userId}/posts")
	public ResponseEntity<Post> createPostForUser(@PathVariable int userId, @RequestBody Post post) {
		Optional<User> user = userRepository.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("id-" + userId);
		post.setAuthor(user.get());
		postRepository.save(post);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				  .path("/{id}")
				  .buildAndExpand(post.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
}
