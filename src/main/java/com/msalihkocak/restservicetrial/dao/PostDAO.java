package com.msalihkocak.restservicetrial.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.msalihkocak.restservicetrial.model.Post;

@Component
public class PostDAO {

	private static List<Post> posts = new ArrayList<Post>(); 
	private static Long postCount = 4L;
	
	static {
		UserDAO service = new UserDAO();
		posts.add(new Post(1L, "Blockchain", "Lorem ipsum dolor blockchain amet.", service.findUserById(1), new Date()));
		posts.add(new Post(2L, "Artificial Intelligence", "Lorem ipsum dolor ai amet.", service.findUserById(2), new Date()));
		posts.add(new Post(3L, "Machine Learning", "Lorem ipsum dolor ml amet.", service.findUserById(3), new Date()));
		posts.add(new Post(4L, "Internet of Things", "Lorem ipsum dolor IoT amet.", service.findUserById(2), new Date()));
	}
	
	public Post findPostById(Long postId) {
		return posts.stream().filter(p -> p.getId() == postId).collect(Collectors.toList()).get(0);
	}
	
	public List<Post> findPosts(){
		return posts;
	}
	
	public Post savePostForUser(int userId, Post post) {
		if(post.getId() == null || post.getId() == 0)
			post.setId(++postCount);
		UserDAO service = new UserDAO();
		post.setAuthor(service.findUserById(userId));
		
		posts.add(post);
		return post;
	}
	
	public Post savePost(Post post) {
		if(post.getId() == null || post.getId() == 0)
			post.setId(++postCount);
		
		posts.add(post);
		return post;
	}
	
	public List<Post> findPostsOfUser(int userId){
		return posts.stream().filter(p -> p.getAuthor().getId() == userId).collect(Collectors.toList());
	} 
}
