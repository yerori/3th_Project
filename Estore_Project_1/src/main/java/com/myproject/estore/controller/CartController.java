package com.myproject.estore.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.CartDTO;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.service.CartService;
import com.myproject.estore.service.ProductService;

@Controller
@RequestMapping("/cart/")
public class CartController {
	
	@Autowired
	private CartService cSerivce;
	
	
	
	//추가
	@PostMapping("cartInsert")
	@ResponseBody
	public String cartInsert(@RequestBody CartDTO cart, Principal p) {
		String userid= p.getName();
		cart.setUserid(userid);
		System.out.println("cart user id : "+userid);
		cSerivce.cartInsert(cart);
		
		return "success";
	}
	
	//리스트
	@GetMapping("cartList")
	public String cartPage(Model model, Principal p, Long pnum ) {
		String userid=p.getName();
		List<CartDTO> cList = cSerivce.cartList(userid);//카트리스트
		System.out.println("clist : "+cList);
		model.addAttribute("cList", cList);
		
		return "/order/cartList";
	}
		
	//선택삭제
	@GetMapping("cDelete")
	public String cartDelete(Long cnum) {
		System.out.println(cnum);
		cSerivce.cartDelete(cnum);
		return "redirect:/cart/cartList";
	}
	

	
}
