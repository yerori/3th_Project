package com.myproject.estore.controller;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/shop/")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService sService;
	private final PasswordEncoder pwEncoder;
	
	//mypage
	//마이페이지로
	@GetMapping("mypage")
	public String mypage(Principal principal, Model model) {
		String sid = principal.getName();
		int newOcount = sService.newOrderCount(sid);
		System.out.println("dbwj dkdlel : "+sid);
		int rCount = sService.sRList(sid);
		model.addAttribute("count", newOcount);
		model.addAttribute("rCount", rCount);
		System.out.println("리뷰 카운트 : "+rCount);
		return "/shop/sMypage";
	}
	
	//sInfo
	@GetMapping("sInfo")
	public String sMyinfo(Principal principal, Model model) {
		String email = principal.getName();
		Shop shop = sService.EmailCheck(email);
		model.addAttribute("sInfo",shop);
		return "/shop/shopInfo";
	}
	
	
	//sInfo mypage passwordCheck
	@GetMapping("pCheck")
	@ResponseBody
	public int sPcheck(Principal principal, @RequestParam String password) {
		String email = principal.getName();
		Shop shop = sService.EmailCheck(email);
		String pass = shop.getPassword();//db비번
		
		int flag=0;
		if(pwEncoder.matches(password, pass)==true) {
			flag=1; //비번동일
		}else {
			flag=2; //비번오류
		}		
		return flag;
	}
	
	//정보수정
	@PutMapping("sUpdate/{email}")
	@ResponseBody
	public String userUpdate(@RequestBody Shop shop, AuthEntity auth, @PathVariable String email) {		
		sService.update(shop, auth);		
		return "성공";		
	}
	
	//shop 주문 상세보기
	@GetMapping("orderDetail/{ordernum}")
	public String sOdetail(Principal principal, Model model, @PathVariable String ordernum) {
		String sid = principal.getName();
		OrderDTO info = sService.sOdetailInfo(sid, ordernum);
		List<OrderDTO> list = sService.sOdetailList(sid, ordernum);
		model.addAttribute("info", info);
		model.addAttribute("list", list);
		return "/shop/sOderDetail";
	}
	
	//shop 주문 수정
	@PostMapping("sOupdate")
	@ResponseBody
	public String sOupdate(@RequestParam Long onum, OrderDTO order) {
		sService.sOupdate(order);
		return "success";
	}
	
	//Myproduct List
	@GetMapping("sProduct")
	public String sPList(Principal principal, Model model) {
		String sid = principal.getName();
		List<ProductDTO> sPList = sService.shopPList(sid);
		model.addAttribute("list", sPList);
		
		return "/shop/shopProductList";
	}
	
	//shop newOrder
	@GetMapping("sOrderList")
	public String sOList(Principal principal, Model model) {
		String sid= principal.getName();
		List<OrderDTO> sOlist = sService.shopOList(sid);
		model.addAttribute("sOlist", sOlist);
		return "/shop/shopOrderList";
	}

	
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
