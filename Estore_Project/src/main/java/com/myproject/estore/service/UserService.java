package com.myproject.estore.service;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.myproject.estore.config.auth.dto.SessionUser;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.repository.UserRepository;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository uRepository;
	
	public List<User> findAllDesc(){
		return uRepository.findAll();
	}
	
	public User EmailCheck(String username) {
		System.out.println(uRepository.findByemail(username));
		User user = uRepository.findByemail(username);
		return user;
		
	}
	
	//회원 추가
	@Transactional
	public void save(User user) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		uRepository.save(user);
	}

	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Optional<User> userEntity = uRepository.findByEmail(email);
//		User user = userEntity.get();
//			
//		//롤 부여하기
//	    List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (user.getRole().equals("ADMIN")) 
//            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
//        else if (user.getRole().equals("MANAGER"))
//            authorities.add(new SimpleGrantedAuthority(Role.MANAGER.getValue()));
//        
//        else if (user.getRole().equals("USER"))
//        	authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
//        
//	        
//		return new org.springframework.security.core.userdetails.User
//				(user.getEmail(), user.getPassword(), authorities);
//	}
	
	
	
	
}
