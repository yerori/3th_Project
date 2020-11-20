package com.myproject.estore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.estore.mapper.OrderMapper;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.QnAService;
import com.myproject.estore.service.ReviewService;
import com.myproject.estore.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/admin/")
public class AdminController {
	@Autowired
	private OrderService oService;
	
	@Autowired
	private ReviewService rService;
	
	@Autowired
	private QnAService qService;
	
	
	
	//mypage
	@GetMapping("mypage")
	public String mypage(Model model) {
		int sysCount = oService.sysCount();
		int rCount=rService.sysCount();
		int total = oService.sysCount()*oService.price();
		int weekCount = oService.weekCount();
		int weekPrice = oService.weekPrice();
		int qnaCount = qService.qnaCount();
		model.addAttribute("sysCount",sysCount);
		model.addAttribute("rCount",rCount);
		model.addAttribute("total",total);
		model.addAttribute("weekCount",weekCount);
		model.addAttribute("weekPrice",weekPrice);
		model.addAttribute("qnaCount",qnaCount);
		return "/admin/aMypage";
	}
	

}
