package com.myproject.estore.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class Comment_qnaDTO {
	private int cqnum;
	private int qnum;
	private String content;
	private String uemail;
	private String semail;
	private Date create_date;
}
