package com.binding;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class CommentForm {
	private String name;

	private String email;

	@Lob
	private String comment;

}
