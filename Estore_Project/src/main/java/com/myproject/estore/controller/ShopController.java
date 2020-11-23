package com.myproject.estore.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

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
import com.myproject.estore.dto.PageAction;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.QnADTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.dto.sOrderListDTO;
import com.myproject.estore.dto.sProductListDTO;
import com.myproject.estore.service.ShopService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/shop/")
@RequiredArgsConstructor
public class ShopController {
	private final ShopService sService;
	private final PasswordEncoder pwEncoder;
	
	@Autowired
	private PageAction page;
	
	//mypage
	//마이페이지로
	@GetMapping("mypage")
	public String mypage(Principal principal, Model model) {
		String sid = principal.getName();
		
		//오늘 주문
		int newOcount = sService.newOrderCount(sid);
		int newOsum = sService.newOsum(sid);
		
		//이번주 주문
		int weekOcount = sService.weekOCount(sid);
		int weekOsum = sService.weekOsum(sid);
		
		//오늘 qna
		int todayQcount = sService.tqlist(sid);
		
		//댓글0
		int noReply = sService.noReply(sid);		
		
		model.addAttribute("count", newOcount);
		model.addAttribute("sum", newOsum );
		model.addAttribute("wCount", weekOcount);
		model.addAttribute("wSum", weekOsum);
		model.addAttribute("tQcount", todayQcount);
		model.addAttribute("noReply", noReply);
		int todayReview = sService.todayReview(sid);
		int weekReview = sService.weekReview(sid);
		model.addAttribute("todayReview", todayReview);
		model.addAttribute("weekReview", weekReview);
		return "/shop/sMypage";
	}
	
	//shop 리뷰
	@GetMapping("shopReview")
	public String sReview(Principal principal, Model model) {
		String sid = principal.getName();
		List<ReviewDTO> rList = sService.sRlist(sid);
		model.addAttribute("rList", rList);
		return "/shop/sReview";
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
	public String sPList(Principal principal, Model model, String pageNum, String field, String word) {
		String sid = principal.getName();
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("sid", sid);
		
		int count = sService.sPcount(hm);
		
		//페이징
		int pageSize = 5;
		if(pageNum==null) pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
				
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		List<ProductDTO> sPList = sService.shopPList(hm);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("list", sPList);
		
		return "/shop/shopProductList";
	}
	
	//제품 검색
	@GetMapping("pSearch")
	@ResponseBody
	public sProductListDTO pSearch(Principal principal,String pageNum,String field, String word) {
		String sid= principal.getName();
		
		System.out.println(word);		
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("field", field);
		hm.put("word", word);
		hm.put("sid", sid);
		
		//갯수
		int count = sService.sPcount(hm);		
		
		//페이징
		int pageSize = 5;
		if(pageNum==null) pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
		
		//리스트		
		List<ProductDTO> sPList = sService.shopPList(hm);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		sProductListDTO sList = new sProductListDTO(count, sPList, pageHtml);
		
		return sList;		
	}	
	
	
	//shop newOrder
	@GetMapping("sOrderList")
	public String sOList(Principal principal, Model model, String pageNum, String field, String word) {
		String sid= principal.getName();
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("sid", sid);
		
		//갯수
		int count = sService.sOcount(hm);
		
		//페이징
		int pageSize = 5;
		if(pageNum==null) pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		
		List<OrderDTO> sOlist = sService.shopOList(hm);
		model.addAttribute("sOlist", sOlist);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		
		return "/shop/shopOrderList";
	}
	
	//order search
	@GetMapping("oSearch")
	@ResponseBody
	public sOrderListDTO oSearch(Principal principal,String pageNum,String field, String word) {
		String sid= principal.getName();
		
		System.out.println(word);
		
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("field", field);
		hm.put("word", word);
		hm.put("sid", sid);
		
		//갯수
		int count = sService.sOcount(hm);
		
		//페이징
		int pageSize = 5;
		if(pageNum==null) pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
		
		//리스트
		
		List<OrderDTO> sOlist = sService.shopOList(hm);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		sOrderListDTO oList = new sOrderListDTO(count, sOlist, pageHtml);
		
		return oList;		
	}
	
	
	
	//shop qna 리스트
	@GetMapping("sQnA")
	public String sQlsit(Principal principal, Model model) {
		String sid = principal.getName();
		//System.out.println("sid:" + sid);
		List<QnADTO> sQlist = sService.sQlist(sid);
		model.addAttribute("sQlist", sQlist);
		System.out.println(sQlist);
		return "/shop/shopQnA";
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
