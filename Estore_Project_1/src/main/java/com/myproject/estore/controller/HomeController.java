package com.myproject.estore.controller;

import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.myproject.estore.config.auth.dto.SessionAuth;
import com.myproject.estore.config.auth.dto.SessionUser;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HomeController {
	
	private final UserService uService;
	private final HttpSession httpSession;
	
	@GetMapping("/")
	public String home(Locale locale, Model model) {
	   
		return "index";
	}
	
	
   @GetMapping("loginform")
   public void index(Model model) {
       model.addAttribute("posts", uService.findAllDesc());

       SessionUser user = (SessionUser) httpSession.getAttribute("user");

       
       if(user != null){
           model.addAttribute("userName", user.getEmail());
       }
   }
   
   //cart
  	@GetMapping("cart")
  	public void cart() {
  		
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
	
}
