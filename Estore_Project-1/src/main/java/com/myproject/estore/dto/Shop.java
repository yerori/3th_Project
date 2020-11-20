package com.myproject.estore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Shop {
	@Id
	private String email;
	@Column(nullable = false)
	private String sname;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String phone;
	@Column(nullable = false)
	private String zipcode;
	@Column(nullable = false)
	private String addr;
	
}
