package com.myproject.estore.dto;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor	//파라미터 없는 생성자 생성
@Entity(name="user")
public class User  {
	   @Id
	   private String email;
	 
	   @Column(nullable = false)
	   private String name;
	   
	   @Column
	   private String password;	
	   
	   @Column
	   private String addr;
	   
	   @Column
	   private String zipcode;
	   
	   @Column
	   private String picture;
	   
	   @Column
	   private String phone;
	   
	   @Enumerated(EnumType.STRING)
	   @Column
	   private Role role;

	   @Builder
	   public User(String name, String email, String picture, Role role) {
	       this.name = name;
	       this.email = email;
	       this.picture = picture;
	       this.role = role;
	   }

	   public User update(String name, String picture) {
	       this.name = name;
	       this.picture = picture;

	       return this;
	   }

	   public String getRoleKey() {
	       return this.role.getKey();
	   }
}
