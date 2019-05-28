package com.msalihkocak.restservicetrial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msalihkocak.restservicetrial.dao.PostRepository;
import com.msalihkocak.restservicetrial.exception.PostNotFoundException;
import com.msalihkocak.restservicetrial.model.Post;

@RestController
public class PostJPAService {
	
	@Autowired
	private PostRepository postRepository;
	
	@GetMapping("/jpa/posts/{postId}")
	public Post getPostDetails(@PathVariable Long postId) {
		Optional<Post> post = postRepository.findById(postId);
		if(!post.isPresent())
			throw new PostNotFoundException("Post not found with id: " + postId);
		return post.orElse(new Post());
	}
	
	@GetMapping("/jpa/posts")
	public List<Post> getAllPosts(){
		return postRepository.findAll();
	}
	
	@PostMapping("/jpa/posts")
	public Post createPost(@RequestBody Post post) {
		return postRepository.save(post);
	}
}
