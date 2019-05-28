package com.msalihkocak.restservicetrial.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.msalihkocak.restservicetrial.model.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
