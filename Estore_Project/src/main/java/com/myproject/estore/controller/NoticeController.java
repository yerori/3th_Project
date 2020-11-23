package com.myproject.estore.controller;

import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.myproject.estore.dto.NoticeDTO;
import com.myproject.estore.service.NoticeService;

@Controller
@RequestMapping("/notice/")
public class NoticeController {
	@Autowired
	private NoticeService nService;
	
	//추가하기 폼
	@GetMapping("insert")
	public String list() {		
		return "/notice/nInsert";
	}
	
	//추가하기
	@PostMapping("insert")
	public String insert(NoticeDTO notice, HttpServletRequest request) throws IllegalStateException, IOException {
		String fileName = "";
		MultipartFile uploadFile = notice.getUploadFile();
		if(uploadFile.isEmpty()) {}
		else {
			String originalFileName=uploadFile.getOriginalFilename();
			String ext = FilenameUtils.getExtension(originalFileName);
			
			//파일명 지정
			UUID uuid = UUID.randomUUID();
			fileName = uuid+"."+ext;
			
			//파일 서버 저장 경로
			String root_path = request.getSession().getServletContext().getRealPath("/");
			String attach_path = "resources/upload/notice/";
			uploadFile.transferTo(new File(root_path+attach_path+fileName));
			
		}
		
		notice.setNimg(fileName);
		nService.noticeInsert(notice);
		return "redirect:list";
		
	}
	
	//전체보기
	@GetMapping("list")
	public String list(Model model) {
		List<NoticeDTO> nlist = nService.noticeList();
		model.addAttribute("nlist", nlist);
		return "/notice/nList";
	}
	
	//상세보기
	@GetMapping("view/{nnum}")
	//{nnum} 해서 들고올 때 @PathVariable 매개변수 적어주기
	public String view(@PathVariable("nnum") int nnum, Model model) {
		NoticeDTO notice = nService.nfindByNum(nnum);
		nService.plusCnt(nnum);
		model.addAttribute("notice", notice);
		System.out.println(("notice title : "+notice.getTitle()));
		return "/notice/nDetail";
	}
	
	//수정폼
	@GetMapping("update/{nnum}")
	public String update(@PathVariable("nnum") int nnum, Model model) {
		NoticeDTO notice = nService.nfindByNum(nnum);
		String fileName = notice.getNimg();
		
		model.addAttribute("notice", notice);		
		System.out.println("파일이름 : "+fileName);
		model.addAttribute("fileName",fileName);
		return "/notice/nUpdate";
	}
		
	//수정하기
   @PostMapping("update")
   public String update(NoticeDTO notice, HttpServletRequest request, int nnum) throws IllegalStateException, IOException {
      String fileName="";
      
      //수정전 사진
      NoticeDTO originPic = nService.nfindByNum(nnum);
      String rawfileName = originPic.getNimg();
      
      MultipartFile uploadFile = notice.getUploadFile();
      if(uploadFile.getSize()>0) {
         String originalFileName = uploadFile.getOriginalFilename();
         String ext = FilenameUtils.getExtension(originalFileName);
         
         UUID uuid = UUID.randomUUID();
         fileName = uuid+"."+ext;
         
         String root_path = request.getSession().getServletContext().getRealPath("/");
         String attach_path = "resources/upload/notice";
         uploadFile.transferTo(new File(root_path+attach_path+fileName));
         notice.setNimg(fileName);
      }
      else {
         notice.setNimg(rawfileName);
      }
      
      nService.nUpdate(notice);
      return "redirect:list";
   }
	
   @GetMapping("delete")
   @ResponseBody
   public String delete(int nnum) {
	   nService.nDelete(nnum);
	   return "success";
   }
}
