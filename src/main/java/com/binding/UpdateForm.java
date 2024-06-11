package com.binding;

import jakarta.persistence.Lob;
import lombok.Data;
@Data
public class UpdateForm 
{
	private String title;

	private String shortDescription;

	@Lob
	private String mainContent;

}
