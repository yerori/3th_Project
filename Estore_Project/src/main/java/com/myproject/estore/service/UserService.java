package com.myproject.estore.service;

import java.util.List;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.repository.AuthRepository;
import com.myproject.estore.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository uRepository;
	private final AuthRepository aRepository;
	@Autowired
	private PasswordEncoder pwEncoder;
	
	//회원 추가
	@Transactional
	public void save(User user, AuthEntity auth) {
		user.setRole(Role.USER);
		//암호화 전
		String rawpassword = user.getPassword();		
		//암호화 후
		String encodepassword = pwEncoder.encode(rawpassword);
		
		user.setPassword(encodepassword);
		System.out.println("encodepassword : "+encodepassword);
		System.out.println("email : "+user.getEmail());
		AuthEntity.builder()
			.email(user.getEmail())
			.password(encodepassword)
	        .role(user.getRole())
	        .build();
		
		aRepository.save(auth);
		System.out.println("encodepassword : "+encodepassword);
		uRepository.save(user);
	}
	
	public List<User> findAllDesc(){
		return uRepository.findAll();
	}
	
	public User EmailCheck(String email) {
		System.out.println(uRepository.findByemail(email));
		User user = uRepository.findByemail(email);
		return user;
		
	}
			
}
