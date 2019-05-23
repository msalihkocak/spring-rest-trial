package com.msalihkocak.restservicetrial.model;

import java.util.Date;

public class Post {
	private Long id;
	private String title;
	private String body;
	private User author;
	private Date publishDate;
	
	public Post(Long id, String title, String body, User author, Date publishDate) {
		super();
		this.id = id;
		this.title = title;
		this.body = body;
		this.author = author;
		this.publishDate = publishDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	public User getAuthor() {
		return author;
	}

	public void setAuthor(User author) {
		this.author = author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
}
