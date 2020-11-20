package com.myproject.estore.dto;


import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class ProductDTO {
	private long pnum;
	private String sid;
	private String ptype;
	private String pname;
	private String price;
	private String pimg;
	private String pdetail;
	private MultipartFile uploadFile; 	
	private Date create_date;
	private String sname;
	
	private List<CartDTO> cart;
	private List<ReviewDTO> review;
	
}
