package com.response;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class EditForm {
	
	private Integer id;
	
	private String title;

	private String shortDescription;

	@Lob
	private String mainContent;
	

}
