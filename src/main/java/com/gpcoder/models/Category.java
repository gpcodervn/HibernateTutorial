package com.gpcoder.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table
public class Category {

	@Id
//	@GeneratedValue(strategy = GenerationType.TABLE)
//	@GeneratedValue(
//		strategy = GenerationType.TABLE,
//		generator = "table-generator"
//	)
//	@TableGenerator(
//		name =  "table-generator",
//		table = "table_identifier",
//		pkColumnName = "column_name",
//		valueColumnName = "value_column_name",
//		pkColumnValue = "category",
//		allocationSize = 5
//	)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String name;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
	@OrderBy("title")
	private Set<Post> posts;
}
