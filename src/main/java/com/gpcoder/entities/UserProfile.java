package com.gpcoder.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_profile")
public class UserProfile {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String address;

	private Integer gender;

	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_user_profile"))
	private User user;
}
