package com.myproject.estore.config.auth.dto;

import java.io.Serializable;

import javax.persistence.Entity;

import com.myproject.estore.dto.User;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SessionUser implements Serializable {
	private String name;
	private String email;
	private String picture;
	
	public SessionUser(User user) {
		this.name=user.getName();
		this.email=user.getEmail();
		this.picture=user.getPicture();
	}
}
