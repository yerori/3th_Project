package com.myproject.estore.dto;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class NoticeDTO {
	private Long nnum;
	private String title;
	private String content;
	private Date create_date;
	private String nimg;
	private int hitcount;
	private MultipartFile uploadFile;
}
