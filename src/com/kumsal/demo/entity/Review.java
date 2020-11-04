package com.kumsal.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
@Entity
@Table(name="review")
public class Review {
	@Id
	@Column(name="id")
	private int id;
	
	@Column(name="comment")
	private String Comment;
	
}
