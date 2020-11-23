package com.myproject.estore.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ReviewDTO {
	private int rnum;
	private int pnum;
	private int onum;
	private String title;
	private String content;
	private String email;
	private String sid;
	private int rate;
	private Date create_date;
	
	//조인
	private String pname;
}
