
package com.myproject.estore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.config.auth.LoginUser;
import com.myproject.estore.config.auth.dto.SessionUser;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
	
	private final UserService uService;
	private final HttpSession httpSession;
	private BCryptPasswordEncoder pwEncoder;
	
 
	//회원가입
	@PostMapping("join")
	public String join(HttpServletRequest request, User user) {
		user.setRole(Role.USER);
		
		//암호화 전
		System.out.println("password : "+user.getPassword());
		
		//암호화 후
		String password = pwEncoder.encode(user.getPassword());
		//set
		user.setPassword(password);
		System.out.println("password2 : "+password);
		uService.save(user);
		
		return "loginform";
	}
	
	//이메일 중복 확인
	@PostMapping("emailCheck")
	@ResponseBody
	public String emailCheck(HttpServletRequest request, String username) {
		User user = uService.EmailCheck(username);
		String result="";
		
		if(user!=null) result="no";
		else result="yes";
		return result;		
	}
	
	
}
