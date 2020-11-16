package com.myproject.estore.config.auth.dto;

import java.io.Serializable;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Role;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SessionAuth implements Serializable {
	private String email;
	private String password;
	private Role role;
	
	public SessionAuth(Auth auth) {
		this.email=auth.getEmail();
		this.password=auth.getPassword();
		this.role=auth.getRole();
	}
}
