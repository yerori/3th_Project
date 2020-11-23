package com.myproject.estore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.repository.AuthRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthService implements UserDetailsService{
	
	private final AuthRepository aRepository;
	
	public void save(AuthEntity auth) {
		aRepository.save(auth);
	}
	
	//이메일 체크 
   public Optional<AuthEntity> EmailCheck(String email) {
      System.out.println(aRepository.findByEmail(email));
      Optional<AuthEntity> auth = aRepository.findByEmail(email);
      return auth;      
   }
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println("username : " + username);
		
		Optional<AuthEntity> authEntity = aRepository.findByEmail(username);
		AuthEntity aEntity = authEntity.get();
		System.out.println("role : " + aEntity.getRole());
		
		System.out.println("role2 : " + Role.MANAGER.getKey());
		
		
		//롤 부여하기
	    List<GrantedAuthority> authorities = new ArrayList<>();

	    String role = aEntity.getRole().toString();
	    
        if (("admin@admin.com").equals(username)) 
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getKey()));
        else if (role.equals("MANAGER"))
            authorities.add(new SimpleGrantedAuthority(Role.MANAGER.getKey()));
        
        else if (role.equals("USER"))
        	authorities.add(new SimpleGrantedAuthority(Role.USER.getKey()));
        
	        
		return new org.springframework.security.core.userdetails.User
				(aEntity.getEmail(), aEntity.getPassword(), authorities);
	}
}
