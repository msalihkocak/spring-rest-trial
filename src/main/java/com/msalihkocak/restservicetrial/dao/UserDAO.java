package com.msalihkocak.restservicetrial.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.msalihkocak.restservicetrial.model.User;

@Component
public class UserDAO {
	
	private static List<User> users = new ArrayList<User>();
	private static int idCounter = 4;
	
	static {
		users.add(new User(1, "Salih", new Date()));
		users.add(new User(2, "Fatih", new Date()));
		users.add(new User(3, "Ali", new Date()));
		users.add(new User(4, "Şamil", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if(user.getId() == null || user.getId() == 0) {
			user.setId(++idCounter);
		}
		users.add(user);
		return user;
	}
	
	public User findUserById(int id) {
		return users.stream().filter(u -> u.getId() == id).collect(Collectors.toList()).get(0);
	}
	
	public boolean removeUserById(int id) {
		return users.removeIf(u -> u.getId() == id);
	}
}
