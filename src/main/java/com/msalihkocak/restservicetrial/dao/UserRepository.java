package com.msalihkocak.restservicetrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.msalihkocak.restservicetrial.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	 
}
