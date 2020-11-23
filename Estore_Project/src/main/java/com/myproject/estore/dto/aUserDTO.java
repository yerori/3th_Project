package com.myproject.estore.dto;

import java.util.List;

import org.springframework.security.core.userdetails.User;

import lombok.Builder;
import lombok.Data;

@Data
public class aUserDTO {
	
	private int count;
	private String pageHtml;
	
	private List<User> ulist;

	@Builder
	public aUserDTO(int count, List<User> uList, String pageHtml) {
		this.count=count;
		this.ulist=uList;
		this.pageHtml=pageHtml;
	}
}