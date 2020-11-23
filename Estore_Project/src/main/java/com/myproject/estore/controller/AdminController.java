package com.myproject.estore.controller;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.estore.dto.ContactDTO;
import com.myproject.estore.dto.OrderDTO;
import com.myproject.estore.dto.PageAction;
import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.dto.aOrderDTO;
import com.myproject.estore.dto.aShopDTO;
import com.myproject.estore.dto.aUserDTO;
import com.myproject.estore.dto.sProductListDTO;
import com.myproject.estore.mapper.OrderMapper;
import com.myproject.estore.service.AdminService;
import com.myproject.estore.service.ContactService;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.ProductService;
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
	
	@Autowired
	private AdminService aService;
	
	@Autowired
	private PageAction page;
	
	@Autowired
	private ShopService sService;
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private ContactService cService;
	
	//mypage
	@GetMapping("mypage")
	public String mypage(Model model) {
		int sysCount = oService.sysCount();
		int rCount=rService.sysCount();
		int total = oService.sysCount()*oService.price();
		int weekCount = oService.weekCount();
		int weekPrice = oService.weekPrice();
		int qnaCount = qService.qnaCount();
		int noReply = qService.noReply();
		model.addAttribute("sysCount",sysCount);
		model.addAttribute("rCount",rCount);
		model.addAttribute("total",total);
		model.addAttribute("weekCount",weekCount);
		model.addAttribute("weekPrice",weekPrice);
		model.addAttribute("qnaCount",qnaCount);
		model.addAttribute("noReply",noReply);
		return "/admin/aMypage";
	}
	
	@GetMapping("sInfo")
	public String sInfo(Model model, String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = aService.sCont(hm);
		
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
		
		List<Shop> sList = aService.sList(hm);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("list", sList);
		
		return "/admin/aShopList";
	}
	
	//주문 상세보기
	@GetMapping("oDetail/{ordernum}")
	public String sOdetail(Principal principal, Model model, @PathVariable String ordernum) {
		OrderDTO info = aService.uOdetailInfo(ordernum);
		List<OrderDTO> list = aService.uOdetailList(ordernum);
		System.out.println("list : "+list);
		model.addAttribute("info", info);
		model.addAttribute("list", list);
		return "/admin/uOderDetail";
	}
	
	@GetMapping("sSearch")
	@ResponseBody
	public aShopDTO sInfo(String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = aService.sCont(hm);
		
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
		
		List<Shop> sList = aService.sList(hm);
		
		System.out.println(sList);
		
		aShopDTO aList = new aShopDTO(count, sList, pageHtml);
		
		return aList;
	}
	
	@GetMapping("aOList")
	public String aOList(Model model, String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = aService.oCont(hm);
		
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
		
		List<OrderDTO> sList = aService.oList(hm);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("list", sList);
		
		return "/admin/aOrderList";
	}
	
	@GetMapping("aOsearch")
	@ResponseBody
	public aOrderDTO aOsearch(String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		int count = aService.oCont(hm);
		
		//페이징
		int pageSize = 5;
		if(pageNum==null) pageNum ="1";
		int currentPage = Integer.parseInt(pageNum);//현재페이지
		int startRow = (currentPage-1)*pageSize+1;//첫 행
		int endRow = startRow+pageSize-1; //마지막 행
		if(endRow>count) endRow=count; //마지막 게시글

		hm.put("startRow",startRow);
		hm.put("endRow", endRow);
	    hm.put("field", field);
	    hm.put("word", word);   		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		List<OrderDTO> oList = aService.oList(hm);
		
		System.out.println(field +"/"+ word);
		System.out.println(count);
		System.out.println(oList);
		
		aOrderDTO aOlist = new aOrderDTO(count, oList, pageHtml);
		
		
		return aOlist;
	}
	
	//shop 상세보기
	@GetMapping("sDetail/{email}")
	public String detail(@PathVariable("email") String email, Model model) {
		Shop shop = sService.EmailCheck(email);
		model.addAttribute("shop", shop);
		return "/admin/aShopDetail";
	}
	
	@GetMapping("sDelete")
	@ResponseBody
	public String delete(String email) {
		sService.sDelete(email);
		return "success";
	}
	
	//리뷰 리스트
	@GetMapping("sRlist")
	public String sRlist(Model model) {
		List<ReviewDTO> rlist = aService.rList();
		model.addAttribute("rlist", rlist);
		return "/admin/aReview";
	}
	
	@GetMapping("aUser")
	public String aUser(Model model, String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = aService.uCount(hm);
		
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
		
		List<User> uList = aService.uList(hm);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("list", uList);
		
		return "/admin/aUserList";
	}
	
	@GetMapping("uSearch")
	@ResponseBody
	public aUserDTO uInfo(String pageNum, String field, String word) {
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		
		int count = aService.uCount(hm);
		
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
		
		List<User> uList = aService.uList(hm);
		
		aUserDTO ulist = new aUserDTO(count, uList, pageHtml);
		
		return ulist;
	}
	
	//제품리스트
	@GetMapping("aProduct")
	public String sPList(Principal principal, Model model, String pageNum, String field, String word) {
		String sid = principal.getName();
		
		HashMap<String, Object> hm = new HashMap<String, Object>();
		hm.put("field", field);
		hm.put("word", word);
		hm.put("sid", sid);
		
		int count = aService.aPcount(hm);	
		
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
		
		List<ProductDTO> aPList = aService.aPlist(hm);
		model.addAttribute("count", count);
		model.addAttribute("pageHtml", pageHtml);
		model.addAttribute("list", aPList);
		
		return "/admin/aProductList";
	}
	
	//제품 검색
	@GetMapping("pSearch")
	@ResponseBody
	public sProductListDTO pSearch(Principal principal,String pageNum,String field, String word) {

		HashMap<String, Object> hm = new HashMap<String, Object>();
		
		hm.put("field", field);
		hm.put("word", word);
		
		//갯수
		int count = aService.aPcount(hm);	
		
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
		List<ProductDTO> aPList = aService.aPlist(hm);
		
		String pageHtml = page.paging(count, pageSize, currentPage, field, word);
		
		sProductListDTO sList = new sProductListDTO(count, aPList, pageHtml);
		
		return sList;		
	}	

	
	//contact 리스트
	@GetMapping("cList")
	public void cList(Model model) {
		List<ContactDTO> cdto = cService.cList();
		model.addAttribute("contact", cdto);
	}
	
	//contact 상세보기
	@GetMapping("cDetail/{cnum}")
	public String cDetail(Model model,@PathVariable int cnum) {
		ContactDTO cdto = cService.cfindByNum(cnum);
		model.addAttribute("contact", cdto);
		return "/admin/cDetail";
	}
	
	//contact 삭제
	@GetMapping("cDelete")
	@ResponseBody
	public String delete(int cnum) {
		cService.cDelete(cnum);
		return "success";
	}
	

	//product delete
	@GetMapping("productDelete")
	public String pDelete(Long pnum) {
		pService.productDelete(pnum);
		return "redirect:/admin/aProduct";
	}
	

}
