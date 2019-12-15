package com.gpcoder.entities;
// Generated Nov 26, 2019 1:41:36 AM by Hibernate Tools 4.3.5.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Post generated by hbm2java
 */
@Entity
@Table(name = "post", catalog = "gp_cms_system")
public class Post implements java.io.Serializable {

	private long id;
	private Category category;
	private User user;
	private String title;
	private String content;

	public Post() {
	}

	public Post(long id) {
		this.id = id;
	}

	public Post(long id, Category category, User user, String title, String content) {
		this.id = id;
		this.category = category;
		this.user = user;
		this.title = title;
		this.content = content;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(name = "title")
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Column(name = "content")
	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
