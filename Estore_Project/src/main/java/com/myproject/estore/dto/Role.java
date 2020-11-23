package com.myproject.estore.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	
	USER("ROLE_USER"),
	ADMIN("ROLE_ADMIN"),
	MANAGER("ROLE_MANAGER");
	
	private final String key;
	
//	USER("ROLE_USER", "일반 사용자"),
//	ADMIN("ROLE_ADMIN", "관리자"),
//	MANAGER("ROLE_MANAGER", "매니저");
//	
//	private final String key;
//	private final String title;
//	private String value;
//	
}
