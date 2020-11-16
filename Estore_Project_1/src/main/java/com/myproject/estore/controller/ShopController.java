package com.myproject.estore.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("shop")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService sService;
	private final PasswordEncoder pwEncoder;
	
	//shop 추가
	@PostMapping("insert")
	public String join(Shop shop, Auth auth) {
		String rawPassword = shop.getPassword();
		System.out.println("인코딩 전 비밀번호 : "+rawPassword);
		String encPassword = pwEncoder.encode(rawPassword);
		System.out.println("인코딩 후 비밀번호 : "+encPassword);
		
		sService.save(shop, auth);
		return "loginform";
	}
	
	//이메일 중복 확인
	@PostMapping("emailCheck")
	@ResponseBody
	public String emailCheck(HttpServletRequest request, String email) {
		Shop shop = sService.EmailCheck(email);
		String result="";
		
		if(shop!=null) result="no";
		else result="yes";
		return result;		
	}
	
}
