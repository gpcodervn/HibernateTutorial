package com.gpcoder.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity(name = "User")
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String fullname;

	@Column(nullable = false, length = 255, unique = true)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(name = "created_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date createdAt;

	@Column(name = "modified_at")
	@Temporal(value = TemporalType.TIMESTAMP)
	private Date modifiedAt;

	@Transient
	private String additionalPropery;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile userProfile;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
	@OrderBy("title")
	private Set<Post> posts;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "user_roles", 
		joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, 
		inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
	private Set<Role> roles;
}
