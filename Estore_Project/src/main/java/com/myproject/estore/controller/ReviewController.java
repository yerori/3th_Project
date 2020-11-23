package com.myproject.estore.controller;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.ReviewDTO;
import com.myproject.estore.service.OrderService;
import com.myproject.estore.service.ProductService;
import com.myproject.estore.service.ReviewService;

@Controller
@RequestMapping("/review/")
public class ReviewController {
	@Autowired
	private ReviewService rService;
	
	@Autowired
	private ProductService pService;
	
	@Autowired
	private OrderService oService;	
	
	
	@GetMapping("plist")		//Model model은 페이지 이동할 때 값 전달할 때 사용
	@ResponseBody				//Map, ArrayList로 담기									
	public Map plist(int pnum, Model model) {
		List<ReviewDTO> rlist = rService.rfindByPnum(pnum);
		Map ratingOptions = new HashMap();
		ratingOptions.put(0, "☆☆☆☆☆");
		ratingOptions.put(1, "★☆☆☆☆");
		ratingOptions.put(2, "★★☆☆☆");
		ratingOptions.put(3, "★★★☆☆");
		ratingOptions.put(4, "★★★★☆");
		ratingOptions.put(5, "★★★★★");
		ratingOptions.put("rlist", rlist);
		
		return ratingOptions;
	}
	
	@GetMapping("insert")
	
	public String insertform (@Param("pnum") Long pnum,@Param("onum") int onum, @Param("sid") String sid, Model model) {
	
		ProductDTO pdto = pService.productDetail(pnum);
		Map reviewform = new HashMap();
		reviewform.put("product", pdto);
		reviewform.put("pnum", pnum);
		reviewform.put("onum", onum);
		reviewform.put("sid", sid);
		
		model.addAttribute("reviewform", reviewform);
		
		
		return "/review/rInsert";
	}
	
	@PostMapping("insert")
	@ResponseBody
	public String insert(@RequestBody ReviewDTO review, Principal p) throws IllegalStateException, IOException {
		review.setEmail(p.getName());
		rService.rInsert(review);
		oService.update(review.getOnum());
		return "success";
	}
	
	@GetMapping("detail/{rnum}/{pnum}")
	public String detail(@PathVariable int rnum,@PathVariable Long pnum,  Model model) {
		ProductDTO pdto = pService.productDetail(pnum);
		model.addAttribute("product", pdto);
		ReviewDTO rdto = rService.rDetail(rnum);
		
		Map ratingOptions = new HashMap();
		ratingOptions.put(0, "☆☆☆☆☆");
		ratingOptions.put(1, "★☆☆☆☆");
		ratingOptions.put(2, "★★☆☆☆");
		ratingOptions.put(3, "★★★☆☆");
		ratingOptions.put(4, "★★★★☆");
		ratingOptions.put(5, "★★★★★");
		
		model.addAttribute("ratingOptions", ratingOptions);
		model.addAttribute("review", rdto);
		return "/review/rDetail";		
	}
	
	@GetMapping("list")
	public String list(Model model) {
		List<ReviewDTO> rlist = rService.rList();
		Map ratingOptions = new HashMap();
		ratingOptions.put(0, "☆☆☆☆☆");
		ratingOptions.put(1, "★☆☆☆☆");
		ratingOptions.put(2, "★★☆☆☆");
		ratingOptions.put(3, "★★★☆☆");
		ratingOptions.put(4, "★★★★☆");
		ratingOptions.put(5, "★★★★★");
		
		model.addAttribute("ratingOptions", ratingOptions);
		model.addAttribute("rlist", rlist);
		return "/review/rList";
	}
	
	@GetMapping("update/{rnum}")
	public String updateform(@PathVariable int rnum, Model model) {
		ReviewDTO rdto = rService.rDetail(rnum);
		model.addAttribute("review", rdto);
		return "/review/rUpdate";
	}
	
	@PostMapping("update")
	public String update(ReviewDTO review) {
		rService.rUpdate(review);
		return "redirect:/review/list";
	}
	
	@GetMapping("delete")
	@ResponseBody
	public String delete(int rnum) {
		rService.rDelete(rnum);
		return "success";
	}
}







