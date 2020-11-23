package com.myproject.estore.controller;

import java.util.Locale;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.config.auth.dto.SessionUser;
import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.User;
import com.myproject.estore.service.AuthService;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	private final AuthService aService;
	private final UserService uService;
	private final HttpSession httpSession;
	//@RequiredArgsConstructor + final = @Autowired
	
	@GetMapping("/")
	public String home(Locale locale, Model model) {
	   
		return "index";
	}
	
	@GetMapping("/contact")
	public String contact(Locale locale, Model model) {
	   
		return "contact";
	}
	
	@GetMapping("/about")
	public String aboutus() {
		return "about";
	}
	
   @GetMapping("loginform")
   public void index(Model model) {
       model.addAttribute("posts", uService.findAllDesc());

       SessionUser user = (SessionUser) httpSession.getAttribute("user");

       
       if(user != null){
           model.addAttribute("userName", user.getEmail());
       }
   }
   
   
   //preinsert form
 	@GetMapping("preInsert")
 	public void preInsert() {
 		
 	}
   
	//user join form
	@GetMapping("uInsert")
	public void uInsert() {
		
	}
	
	//store join form
	@GetMapping("sInsert")
	public void sInsert() {
		
	}
	
	
		
		
	//마이페이지로
	/*
	 * @GetMapping("mypage") public String mypage() { return "/user/uMypage"; }
	 */
	
	//추가
	@PostMapping("insert")
	public String join(User user, Auth auth) {
		System.out.println("cieafsdfdfads");
		System.out.println(user.getEmail());
		uService.save(user, auth);		
		return "loginform";
	}
	
	//이메일 중복 확인
	@GetMapping("emailCheck")
	@ResponseBody
	public String emailCheck(HttpServletRequest request, String email) {
		//Optional : null이면 빈객체를 생성해서 오류 안뜸 
		// 비어있다면 isEmpty()함수 써주기
		Optional<AuthEntity> auth = aService.EmailCheck(email);
		System.out.println("중복확인"+email);
		System.out.println("중복확인 auth   "+auth);
		String result="";
		
		if(!auth.isEmpty()) result="no";
		else result="yes";
		return result;		
	}
}
