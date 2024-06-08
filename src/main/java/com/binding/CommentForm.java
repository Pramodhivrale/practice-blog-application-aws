package com.binding;

import jakarta.persistence.Lob;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class CommentForm {
	private String name;

	private String email;

	@Lob
	private String comment;

}
