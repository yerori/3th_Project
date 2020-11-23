package com.myproject.estore.dto;

import lombok.Data;

@Data
public class CartDTO {

	private Long cnum;
	private Long pnum; //사진 출력을 위한 pnum
	private String userid;
	private String pname;
	private String price;
	private int count;
	private String sid;
	private int sum;
	private String sname;
	
	private String pimg; //product 테이블의 pimg
}
