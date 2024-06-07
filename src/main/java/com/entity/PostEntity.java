package com.entity;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Entity
@Setter
@Getter
@Table(name = "POST_DATA")
public class PostEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer postId;

	private String title;

	private String shortDescription;

	@Lob
	@Column(columnDefinition = "TEXT")
	private String mainContent;

	@CreationTimestamp
	private LocalDate createdOn;

	@UpdateTimestamp
	private LocalDate updatedOn;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserRegistrationEntity user;

	@OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
	private List<Comments> comments;
}
