package com.myproject.estore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "auth")
public class AuthEntity {
	@Id
	private String email;
	@Column
	private String password;
	
	@Enumerated(EnumType.STRING)
	@Column
	private Role role;

	@Builder
	public AuthEntity (String email, String password, Role role) {
		this.email=email;
		this.password=password;
		this.role=role;
	}
	
	public String getRoleKey() {
	       return this.role.getKey();
	}
}