
package com.myproject.estore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Role;
import com.myproject.estore.dto.User;
import com.myproject.estore.service.AuthService;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.ReviewService;
import com.myproject.estore.service.UserService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user/")
@RequiredArgsConstructor
public class UserController {
	
	//@RequiredArgsConstructor + final = @Autowired
	private final UserService uService;
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private PasswordEncoder pwEncoder;
	
	//마이페이지로
	@GetMapping("mypage")
	public String mypage(Principal principal, Model model) {
		String uid = principal.getName();
		//최근한달간주문내역
		List<OrderDTO> uMonthList = uService.uMonthList(uid);
		model.addAttribute("uMonthList", uMonthList);
		return "/user/uMypage";
	}
	
	//정보수정
	@PutMapping("uUpdate/{email}")
	@ResponseBody
	public String userUpdate(@RequestBody User user, AuthEntity auth, @PathVariable String email) {
		
		System.out.println("email:"+email);

		uService.update(user, auth);
		
		//System.out.println(user.getPassword());
		
		return "성공";
		
	}
	
	//유저 전체 orderlist
	@GetMapping("uOrderList")
	public String uOrderList(Model model, Principal principal) {
		String userid = principal.getName();
		List<OrderDTO> uOList = uService.uOrderList(userid);
		model.addAttribute("uOlist", uOList);
		
		return "/user/uOrderList";
	}
	
	//유저 주문 디테일
	@GetMapping("uOdetail/{ordernum}")
	public String uOdetail(Model model, @PathVariable String ordernum, Principal principal) {
		String uid = principal.getName();
		OrderDTO info = uService.uOdetailInfo(uid, ordernum);
		List<OrderDTO> list = uService.uOdetailList(uid, ordernum);
		model.addAttribute("info", info);
		model.addAttribute("list", list);		
		
		return "/user/uOrderDetail";
	}
	
	
	//비밀번호 체크
	@GetMapping("pCheck")
	@ResponseBody
	public int uPcheck(Principal principal, @RequestParam String password) {
		String email = principal.getName();
		User user = uService.EmailCheck(email);
		String pass = user.getPassword();//db비번
		
		int flag=0;
		if(pwEncoder.matches(password, pass)==true) {
			flag=1; //비번동일
		}else {
			flag=2; //비번오류
		}		
		return flag;
	}
	
	//uInfo mypage
	@GetMapping("uInfo")
	public String uMyinfo(Principal principal, Model model) {
		String email = principal.getName();
		User user = uService.EmailCheck(email);
		model.addAttribute("uInfo",user);
		return "/user/uMyinfo";
	}	
	
	//userQnA
	@GetMapping("uQnA")
	public String uQnA(Principal principal, Model model) {
		String umail = principal.getName();
		List<QnADTO> list = uService.uQlist(umail);
		model.addAttribute("qList", list);
		return "/user/uQnA";
	}
	
	//Qdetail
	@GetMapping("uQdetail/{qnum}")
	public String uQdetail(Model model, @PathVariable int qnum ) {
		return "/user/uQdetail";
	}
	
	//유저 리뷰 리스트
	@GetMapping("uReview")
	public String uReview(Principal principal, Model model) {
		String email = principal.getName(); //작성자
		List<ReviewDTO> rList = uService.uRlist(email);
		model.addAttribute("rList", rList);
		return "/user/uReview";
		
	}
}
