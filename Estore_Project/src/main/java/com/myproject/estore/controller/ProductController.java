package com.myproject.estore.controller;

import java.io.File;

import java.io.IOException;
import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.estore.dto.ProductDTO;
import com.myproject.estore.dto.Shop;
import com.myproject.estore.service.ProductService;
import com.myproject.estore.service.ShopService;

@Controller
@RequestMapping("/product/")
public class ProductController {
	@Autowired
	private ProductService pService;
	
	@Autowired
	private ShopService sService;
	
	@GetMapping("productInsert")
	public String toPInsert(Model model, Principal principal) {
		String email = principal.getName();
		Shop shop = sService.EmailCheck(email);
		System.out.println("sname" + shop.getName());
		model.addAttribute("shop", shop);
		return "/product/productInsert";
	}
	
	@PostMapping("productInsert")
	public String productInsert(ProductDTO product, HttpServletRequest request, Principal principal) throws IOException{
		//shop login id
		String sid = principal.getName();
		product.setSid(sid);
		
		String fileName="";
		MultipartFile uploadFile = product.getUploadFile();
		if(uploadFile.isEmpty()) {

		}else {
			
			String originalFileName=uploadFile.getOriginalFilename();			
			String ext = FilenameUtils.getExtension(originalFileName); //확장자구하기

			//파일명 지정
			UUID uuid = UUID.randomUUID();
			fileName=uuid+"."+ext;			
			
			//파일 서버 저장 경로
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "resources/upload/product/"; //webapp 아래의 resources 파일
			uploadFile.transferTo(new File(root_path+attach_path+fileName));		
		
		}
		
		product.setPimg(fileName);
		
		
		pService.productInsert(product);		
		
		return "redirect:/shop/sProduct";
	}
	
	@GetMapping("productList")
	public String pList(Model model, @RequestParam(value="word", required=false, defaultValue="") String word ) {
		
		List<ProductDTO> list = pService.productList(word);
		model.addAttribute("list", list);
		
		return "/product/productList";
	}

	
	//검색용
	@GetMapping("productSearch")
	public String pSearchList(Model model, @RequestParam String word ) {
		//word는 상단 검색어
		List<ProductDTO> list = pService.searchList(word);
		model.addAttribute("list", list);
		
		return "/product/productSearch";
	}


	@GetMapping("productDetail/{pnum}")
	public String pDetail(Model model, @PathVariable Long pnum) {
		ProductDTO product = pService.productDetail(pnum);
		model.addAttribute("product", product);	
		System.out.println("detail "+ product.getSname());
		return "/product/productDetail";
	}
	
	@GetMapping("productUpdate")
	public String pD(Model model, Long pnum) {
		ProductDTO product = pService.productDetail(pnum);
		model.addAttribute("product", product);	
		return "/product/productUpdate";
	}
	
	
	   @PostMapping("productUpdate")
	   public String pUpdate(ProductDTO product, HttpServletRequest request, Long pnum) throws IOException {
	      String fileName="";
	      
	      //수정전 사진 정보
	      ProductDTO orginPic = pService.productDetail(pnum);
	      String rawfileName = orginPic.getPimg();
	      
	      MultipartFile uploadFile = product.getUploadFile();
	      
	      if(uploadFile.getSize()>0) {//새로운 사진 입력
	         String originalFileName=uploadFile.getOriginalFilename();         
	         String ext = FilenameUtils.getExtension(originalFileName); //확장자구하기

	         //파일명 지정
	         UUID uuid = UUID.randomUUID();
	         fileName=uuid+"."+ext;         
	         
	         //파일 서버 저장 경로
	         String root_path = request.getSession().getServletContext().getRealPath("/");
	         String attach_path = "resources/upload/product/"; //webapp 아래의 resources 파일
	         uploadFile.transferTo(new File(root_path+attach_path+fileName));
	         
	         product.setPimg(fileName);         
	      
	      }else {         
	         product.setPimg(rawfileName);
	      }
	         
	      pService.productUpdate(product);         
	      return "redirect:/product/productDetail/"+pnum;
	   }
	
	
	@GetMapping("productDelete")
	public String pDelete(Long pnum) {
		pService.productDelete(pnum);
		return "redirect:/shop/sProduct";
	}
}
