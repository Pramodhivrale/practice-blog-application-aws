package com.response;

import java.time.LocalDate;

import jakarta.persistence.Lob;
import lombok.Data;

@Data
public class ShowPost {

	private Integer postId;
	
	private String title;

	@Lob
	private String maindata;

	private LocalDate createdDate;
	
	

}
