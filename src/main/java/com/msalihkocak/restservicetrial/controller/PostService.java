package com.msalihkocak.restservicetrial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.msalihkocak.restservicetrial.dao.PostDAO;
import com.msalihkocak.restservicetrial.model.Post;

@RestController
public class PostService {
	
	@Autowired
	private PostDAO postDAO;
	
	@GetMapping("/user/{userId}/posts")
	public List<Post> getAllPostsOfUser(@PathVariable int userId) {
		return postDAO.findPostsOfUser(userId);
	}
	
	@GetMapping("/post/{postId}")
	public Post getPostDetails(@PathVariable Long postId) {
		return postDAO.findPostById(postId);
	}
	
	@GetMapping("/posts")
	public List<Post> getAllPosts(){
		return postDAO.findPosts();
	}
	
	@PostMapping("/user/{userId}/posts")
	public Post createPostForUser(@PathVariable int userId, @RequestBody Post post) {
		return postDAO.savePostForUser(userId, post);
	}
	
	@PostMapping("/posts")
	public Post createPost(@RequestBody Post post) {
		return postDAO.savePost(post);
	}
}
