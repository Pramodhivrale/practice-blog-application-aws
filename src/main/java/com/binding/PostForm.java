package com.binding;

import jakarta.persistence.Lob;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PostForm 
{
	
	private String title;

	private String shortDescription;

	@Lob
	private String mainContent;

}
