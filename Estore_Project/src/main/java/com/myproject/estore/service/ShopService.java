package com.myproject.estore.service;


import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.repository.AuthRepository;
import com.myproject.estore.repository.ShopRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ShopService {
	private final ShopRepository sRepository;
	private final AuthRepository aRepository;
	
	public Shop EmailCheck(String email){
		Shop shop = sRepository.findByemail(email);
		return shop;
	}
	
	@Transactional
	public void save (Shop shop, AuthEntity auth) {
		AuthEntity.builder()
		.email(shop.getEmail())
		.password(shop.getPassword())
        .role(Role.MANAGER)
        .build();
		aRepository.save(auth);
		sRepository.save(shop);
	}

}
