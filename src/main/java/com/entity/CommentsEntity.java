package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "COMMENT_TABLE")
public class CommentsEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer commmentId;
	
	private String name;
	
	private String email;
	
	@Lob
	private String comment;
	
	@ManyToOne
	@JoinColumn(name = "postId")
	private PostEntity post;
	
	

}
