package com.myproject.estore.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class QnADTO {
	private int qnum;
	private int pnum;
	private String title;
	private String content;
	private Date create_date;
	private String email;
	private String password;
	private int replyCnt;
	
	//조인
	private String pname;
	private String sid;
}
