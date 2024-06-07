package com.response;

import jakarta.persistence.Lob;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class AddPostData 
{

	private String title;
	
	private String shortDescription;
	
	@Lob
	private String mainContent;
	
	

}
