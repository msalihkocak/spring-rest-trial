package com.msalihkocak.restservicetrial.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	private String body;
	private Date publishDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private User author;
	
	public Post() {
		super();
	}

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

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", body=" + body + ", publishDate=" + publishDate + "]";
	}
	
	
}
