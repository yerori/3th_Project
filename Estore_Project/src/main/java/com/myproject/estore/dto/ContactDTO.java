package com.myproject.estore.dto;

import lombok.Data;

@Data
public class ContactDTO {
	private int cnum;
	private String content;
	private String name;
	private String email;
	private String title;
	private String create_date;
}
