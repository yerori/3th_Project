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
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		System.out.println("username : " + username);
		
		Optional<AuthEntity> authEntity = aRepository.findByEmail(username);
		AuthEntity aEntity = authEntity.get();
		System.out.println("auth : " + aEntity);
			
		//롤 부여하기
	    List<GrantedAuthority> authorities = new ArrayList<>();

        if (aEntity.getRole().equals("ADMIN")) 
            authorities.add(new SimpleGrantedAuthority(Role.ADMIN.getValue()));
        else if (aEntity.getRole().equals("MANAGER"))
            authorities.add(new SimpleGrantedAuthority(Role.MANAGER.getValue()));
        
        else if (aEntity.getRole().equals("USER"))
        	authorities.add(new SimpleGrantedAuthority(Role.USER.getValue()));
        
	        
		return new org.springframework.security.core.userdetails.User
				(aEntity.getEmail(), aEntity.getPassword(), authorities);
	}
}
