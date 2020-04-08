package com.learning.rest.webservices.restfulwebservices.user;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Id;

@Entity
public class Post {
	
	@Id
	@GeneratedValue
	@JsonFilter("PostFilter")
	private Integer Id;
	private String description;
	
	@ManyToOne(fetch =FetchType.LAZY)
	@JsonIgnore
	private User user;

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Post [Id=" + Id + ", description=" + description + "]";
	}

}
