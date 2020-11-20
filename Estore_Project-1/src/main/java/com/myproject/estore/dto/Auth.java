package com.myproject.estore.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Auth {
	private String email;
	private String password;
	private Role role;
	

    public AuthEntity toEntity(){
        return AuthEntity.builder()         
                .email(email)
                .password(password)
                .role(role)
                .build();
    }

	@Builder
	public Auth (String email, String password, Role role) {
		this.email=email;
		this.password=password;
		this.role=role;
	}
}