
package com.myproject.estore.controller;

import java.util.Optional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
	
	//@RequiredArgsConstructor + final = @Autowired
	private final UserService uService;
	
	
 
	//추가
	@PostMapping("insert")
	public String join(User user, AuthEntity auth) {
		
		uService.save(user, auth);		
		return "loginform";
	}
	
	//이메일 중복 확인
	@PostMapping("emailCheck")
	@ResponseBody
	public String emailCheck(HttpServletRequest request, String email) {
		User user = uService.EmailCheck(email);
		String result="";
		
		if(user!=null) result="no";
		else result="yes";
		return result;		
	}
	
	
}
