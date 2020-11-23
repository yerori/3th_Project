package com.myproject.estore.controller;

import java.net.http.HttpRequest;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myproject.estore.dto.Auth;
import com.myproject.estore.dto.AuthEntity;
import com.myproject.estore.dto.CartDTO;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.User;
import com.myproject.estore.service.AuthService;
import com.myproject.estore.service.CartService;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.UserService;

@Controller
@RequestMapping("/order/")
public class OrderController {		
	@Autowired
	private CartService cService;

	@Autowired
	private OrderService oService;
	
	@Autowired
	private UserService uService;
	
	//주문 내용체크
	@GetMapping("oCheck")
	public String oderCheck(Model model, Principal principal) {
		
		String userid = principal.getName();
		
		//회원 정보		
		User user = uService.EmailCheck(userid);
		model.addAttribute("user", user);
		
		//cartList
		List<CartDTO> cart = cService.cartList(userid);
		
		model.addAttribute("cart", cart);
		
		return "/order/orderCheck";
	}
	
	//주문성공
	@PostMapping("oSuccess")
	public String orderSuccess(OrderDTO order, HttpServletRequest request, Principal principal) {
		//주문번호
		int num = oService.getNum(); //주문번호 끝자리로 사용할 시퀀스
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		Date date = new Date();
		String datenum = format.format(date);
		String ordernum = datenum+"-00"+num;
		
		//userid
		String userid = principal.getName();
		
		//sid, pname, pocount, price(소계)는 배열로
		String sid[] = request.getParameterValues("sid");
		String pname[] = request.getParameterValues("pname");
		String pcount[] = request.getParameterValues("pcount");
		String price[] = request.getParameterValues("price");
		String sname[] = request.getParameterValues("sname");
		String pnum[] = request.getParameterValues("pnum");
		
		
		for(int i=0; i<sid.length; i++) {
			order.setOrdernum(ordernum);
			order.setSid(sid[i]);
			order.setPname(pname[i]);
			order.setPcount(pcount[i]);
			order.setPrice(price[i]);
			order.setUserid(userid);
			order.setSname(sname[i]);
			order.setPnum(Integer.parseInt(pnum[i]));
			oService.orderSuccess(order);
		}
		
		//주문이 완료되면 장바구니 내역 삭제
		cService.cartAllDel(userid);		
		
		return "/order/orderConfirm";
	}
	
	@GetMapping("orderConfirm")
	public String oConfirm() {
		return "/order/orderConfirm";
	}
	
	
	
	
}
